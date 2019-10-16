package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordClient {
    private static final Logger logger =
            Logger.getLogger(PasswordClient.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceStub asyncPasswordService;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;

    public PasswordClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
        asyncPasswordService = PasswordServiceGrpc.newStub(channel);
    }

    public void Shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void addNewUser(PasswordRequest newPasswordReq) {
        logger.info("Adding new user: " + newPasswordReq);
        BoolValue result = BoolValue.newBuilder().setValue(false).build();

        try {
            result = syncPasswordService.addHash(newPasswordReq);
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
            return;
        }
        if (result.getValue()) {
            logger.info("Successfully added user: " + newPasswordReq);
        } else {
            logger.warning("Failed to add user");
        }
    }

    private void getHash() {
        StreamObserver<PasswordResponse> responseObserver = new StreamObserver<PasswordResponse>() {
            @Override
            public void onNext(PasswordResponse passwordResponse) {
                logger.info("Received: " + passwordResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                Status status = Status.fromThrowable(throwable);

                logger.log(Level.WARNING, "RPC Error: {0}", status);
            }

            @Override
            public void onCompleted() {
                logger.info("Finished receiving");
                // End program
                System.exit(0);
            }
        };

        try {
            logger.info("Requesting all");
            asyncPasswordService.getHash(Empty.newBuilder().build(), responseObserver);
            logger.info("Returned from requesting all");
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        PasswordClient pwClient = new PasswordClient("localhost", 50551);
        PasswordRequest newRequest = PasswordRequest.newBuilder().setUserId(1234).setPassword("test").build();


        try {
            pwClient.addNewUser(newRequest);
            pwClient.getHash();
        } finally {
            // Keep alive to receive async response
            Thread.currentThread().join();
        }
    }
}
