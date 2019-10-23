package ie.gmit.ds;

import com.google.protobuf.ByteString;
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
    private char[] charPassword; // Use for converting String password from request
    private byte[] salt; // Use for return value: getNextSalt()
    private byte[] expectedHash; // Use for params in isExpectedPassword()

    /**
     * Store userId to return in response
     */
    private int userId;

    /**
     * Constructor - Default
     */
    public PasswordServiceImpl() {
    }

    /**
     * rpc - hash
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void hash(UserInputRequest request, StreamObserver<UserInputResponse> responseObserver) {
        System.out.println(request); // Print the request
//        logger.info("Hash Request: " + request);

        try {
            /**
             * Request from user and run through hashing function
             */
            // Get userID
            userId = request.getUserId();
            System.out.println("UserID: " + userId);

            // Create Salt
            salt = Passwords.getNextSalt();
            System.out.println("Salt: " + salt);

            // Convert user password into char array
            charPassword = request.getPassword().toCharArray();
            System.out.println("Password: " + charPassword);

            // Hash password with salt
            expectedHash = Passwords.hash(charPassword, salt);
            System.out.println("Expected Hash: " + expectedHash);

            /**
             * Creating response to user
             *
             * Sending back: userId, expectedHash, salt
             */
            // Creating response
            UserInputResponse userInputResponse = UserInputResponse.newBuilder()
                    .setUserId(userId)
                    .setSalt(ByteString.copyFrom(salt))
                    .setExpectedHash(ByteString.copyFrom(expectedHash))
                    .build();
            // Send to client
            responseObserver.onNext(userInputResponse);
        } catch (RuntimeException ex) {
//            System.out.println(ex);
            logger.info("Error thrown in hash: " + ex);
        }
        // Commit to client
        responseObserver.onCompleted();
    }

    /**
     * rpc - validate password
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void validate(PasswordValidateRequest request, StreamObserver<PasswordValidateResponse> responseObserver) {

        boolean isValidPassword; // Use for checking if password is valid or not
        System.out.println(request);

        try {
            /**
             * Request from user and run through validation function
             */
            // Get password
            charPassword = request.getPassword().toCharArray();
            System.out.println("Password: " + charPassword);
            // Get salt
            salt = request.getSalt().toByteArray();
            System.out.println("Salt: " + salt);
            // Get expectedHash
            expectedHash = request.getExpectedHash().toByteArray();
            System.out.println("Expected Hash: " + expectedHash);

            // Check if the password is valid or not
            isValidPassword = Passwords.isExpectedPassword(charPassword, salt, expectedHash);
            System.out.println("Is Valid Password: " + isValidPassword);

            /**
             * Creating response to user
             * Sending back: isValidPassword
             */
            PasswordValidateResponse passwordValidateResponse = PasswordValidateResponse.newBuilder()
                    .setValidPassword(isValidPassword)
                    .build();

            // Send to client
            responseObserver.onNext(passwordValidateResponse);
        } catch (RuntimeException ex) {
            System.out.println(ex);
            logger.info("Error thrown in validate: " + ex);
        }
        // Commit to client
        responseObserver.onCompleted();
    }
}
