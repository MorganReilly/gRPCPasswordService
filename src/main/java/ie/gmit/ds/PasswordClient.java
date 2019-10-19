package ie.gmit.ds;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PasswordClient {
//    /**
//     * Client initialisation
//     * Using blocking stubs -- Asynchronous and Synchronous
//     */
//    private static final Logger logger = Logger.getLogger(PasswordClient.class.getName());
//    private final ManagedChannel channel;
//    private final PasswordServiceGrpc.PasswordServiceStub asyncPasswordService;
//    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;
//
//    /**
//     * Constructor
//     *
//     * @param host
//     * @param port
//     */
//    public PasswordClient(String host, int port) {
//        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
//        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
//        asyncPasswordService = PasswordServiceGrpc.newStub(channel);
//    }
//
//    /**
//     * Client shutdown
//     *
//     * @throws InterruptedException
//     */
//    public void shutdown() throws InterruptedException {
//        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//    }
    private static final String HOST = "localhost";
    private static final int PORT = 50551;

    /**
     * Main -- Client Runner
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // Create a channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(HOST, PORT)
                .usePlaintext() // using http, use https in future
                .build();

        // Create a blocking stub with the channel
        PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService =
                PasswordServiceGrpc.newBlockingStub(channel);

        // Create request
        UserInputRequest userInputRequest = UserInputRequest.newBuilder()
                .setUserId(001)
                .setPassword("password")
                .build();

        // Send request using the stub
        System.out.println("Sending Request");
        UserInputResponse userInputResponse = syncPasswordService.hash(userInputRequest);

        System.out.println("Received response: " +
                " hash: " + userInputResponse.getExpectedHash() +
                " salt: " + userInputResponse.getSalt() +
                " userID: " + userInputResponse.getUserId());

        channel.shutdown();
    }
}
