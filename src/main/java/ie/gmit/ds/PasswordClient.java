package ie.gmit.ds;

import com.google.protobuf.ByteString;
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
//    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;
//
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
//    }
////
//
//    /**
//     * Client shutdown
//     *
//     * @throws InterruptedException
//     */
//    public void shutdown() throws InterruptedException {
//        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//    }
//
//    /**
//     * Client Stubs
//     * Synchronous call
//     */
//    public void hashNewPassword(UserInputRequest userInputRequest) {
//        System.out.println(user);
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
        String randomPassword = Passwords.generateRandomPassword(6);
        /**
         * Step 1 -- Create a channel
         */
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(HOST, PORT)
                .usePlaintext() // using http, use https in future
                .build();

        /**
         * Step 2 -- Create a blocking stub with the channel
         */
        PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService =
                PasswordServiceGrpc.newBlockingStub(channel);

        /**
         * Step 3 -- Create Request
         */
        UserInputRequest userInputRequest = UserInputRequest.newBuilder()
                .setUserId(001)
                .setPassword(randomPassword)
                .build();

        /**
         * Step 4 -- Send request using the stub
         */
        UserInputResponse userInputResponse = syncPasswordService.hash(userInputRequest);
        System.out.println("Sending Request: \n" + userInputRequest);
        System.out.println("Received response: \n" + userInputResponse);

        /**
         * Retrieve from previous response from user in oder to validate password
         *
         * Store: password (char[]), salt (byte[]), expectedHash (byte[])
         */
        byte[] saltFromRes = userInputResponse.getSalt().toByteArray();; // Use for storing salt from previous response
        byte[] expectedHashFromRes = userInputResponse.getExpectedHash().toByteArray();; // Use for storing hash from previous response

        /**
         * Step 3 -- Repeat for validation -- Create request
         */
        PasswordValidateRequest passwordValidateRequest = PasswordValidateRequest.newBuilder()
                .setPassword(randomPassword)
                .setSalt(ByteString.copyFrom(saltFromRes))
                .setExpectedHash(ByteString.copyFrom(expectedHashFromRes))
                .build();

        /**
         * Step 4 -- Repeat for validation -- Send request using the stub
         */
        PasswordValidateResponse passwordValidateResponse = syncPasswordService.validate(passwordValidateRequest);
        System.out.println("Sending Request: \n" + passwordValidateRequest);
        System.out.println("Received response: \n" + passwordValidateResponse);

        /**
         * Step 5 -- Shutdown channel
         */
        channel.shutdown();
    }
}
