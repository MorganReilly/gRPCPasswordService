package ie.gmit.ds.client;

import com.google.protobuf.ByteString;
import ie.gmit.ds.*;
import ie.gmit.ds.api.User;
import ie.gmit.ds.api.UserLogin;
import ie.gmit.ds.db.UserDB;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserClient {

    /**
     * Client initialisation
     * Using blocking stubs -- Asynchronous and Synchronous
     */
    private static final Logger logger = Logger.getLogger(UserClient.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService; // Synchronous call
    private final PasswordServiceGrpc.PasswordServiceStub asyncInventoryService; // Asynchronous call

    /**
     * Variables
     * HOST, PORT -- Connection
     */
    private static final String HOST = "localhost";
    private static final int PORT = 50551;

    /**
     * Constructor
     *
     * @param host
     * @param port
     */
    public UserClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
        asyncInventoryService = PasswordServiceGrpc.newStub(channel);
    }

    /**
     * Client shutdown
     *
     * @throws InterruptedException
     */
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Hash password
     */
    public void Hash(User user) {
        StreamObserver<UserInputResponse> responseStreamObserver = new StreamObserver<UserInputResponse>() {
            @Override
            public void onNext(UserInputResponse userInputResponse) {
                // Create an instance of the database and add a user here
                // This allows for specific entries on the user
                // Also avoids storing the password
                User u = new User(userInputResponse.getUserId(), user.getUserName(),
                        user.getEmail(), userInputResponse.getExpectedHash(), userInputResponse.getSalt());
                UserDB.createUser(u.getUserId(), u);
                logger.info("USER: " + userInputResponse);
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        };
        try {
            asyncInventoryService.hash(UserInputRequest.newBuilder()
                    .setUserId(user.getUserId())
                    .setPassword(user.getPassword())
                    .build(), responseStreamObserver);
        } catch (StatusRuntimeException ex) {
            logger.warning("Exception: " + ex);
        }
    }

    /**
     * Validate password
     */
    public boolean Validate(UserLogin userLogin, ByteString salt, ByteString expectedHash) {
        PasswordValidateRequest passwordValidateRequest;
        try {
            // Create request
            passwordValidateRequest = PasswordValidateRequest.newBuilder()
                    .setPassword(userLogin.getPassword())
                    .setSalt(salt)
                    .setExpectedHash(expectedHash)
                    .build();
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "Validate Request Failed", ex.getStatus());
            return false;
        }
        // Send response using stub
        PasswordValidateResponse passwordValidateResponse = syncPasswordService.validate(passwordValidateRequest);
        logger.info("Validate Request\nPassword: " + userLogin.getPassword() + "\nSalt: " + salt + "\nHashed Password: " + expectedHash); // Logging request
        logger.info("Validate Response\nIs Valid Password: " + passwordValidateResponse.getValidPassword()); // Logging response
        return true;
    }
}