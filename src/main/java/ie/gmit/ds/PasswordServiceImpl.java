package ie.gmit.ds;

import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {

    private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

    /**
     * Variables for:
     * checking password
     * hashing
     * salting
     */
    private byte[] salt; // Use for return value: getNextSalt()
    private char[] charPassword; // Use for converting String password from request
    private byte[] expectedHash; // Use for params in isExpectedPassword()

    /**
     * Store userid to return in response
     */
    private int userId;

    /**
     * Constructor - Default
     */
    public PasswordServiceImpl() {
    }

    /**
     * rpc hash from PasswordService
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void hash(UserInputRequest request, StreamObserver<UserInputResponse> responseObserver) {
        System.out.println(request);

        try {
            /**
             * Request from user and run through hashing function
             */
            // Get userID
            userId = request.getUserId();
            System.out.println("UserID: " + userId);
            logger.info("UserID: " + userId);

            // Create Salt
            salt = Passwords.getNextSalt();
            System.out.println("Created Salt: " + salt);
            logger.info("Created Salt: " + salt);

            // Convert user password into char array
            charPassword = request.getPassword().toCharArray();
            System.out.println("charPassword: " + charPassword);
            logger.info("charPassword: " + charPassword);

            // Hash password with salt
            expectedHash = Passwords.hash(charPassword, salt);
            System.out.println("expectedHash: " + expectedHash);
            logger.info("expectedHash: " + expectedHash);

            /**
             * Creating response to user
             * Sending back: userId, expectedHash, salt
             */
            // Creating response
            UserInputResponse response = UserInputResponse.newBuilder()
                    .setUserId(userId)
                    .setExpectedHash(expectedHash.toString())
                    .setSalt(salt.toString())
                    .build();
            // Send to client
            responseObserver.onNext(response);
        } catch (RuntimeException ex) {
            System.out.println(ex);
            logger.info("Error thrown in PasswordServiceImpl: " + ex);
        }
        // Commit to client
        responseObserver.onCompleted();
    }
}
