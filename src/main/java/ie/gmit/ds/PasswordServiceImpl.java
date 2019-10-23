package ie.gmit.ds;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {
    private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

    /**
     * Variables for:
     * checking password
     * hashing password
     * salting password
     * isValid password
     */
    private char[] charPassword; // Use for converting String password from request
    private byte[] salt; // Use for return value: getNextSalt()
    private byte[] expectedHash; // Use for params in isExpectedPassword()
    private boolean isValidPassword; // Use for checking if password is valid or not
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
        logger.info("Hash Request: " + request);

        try {
            /**
             * Request from user and run through hashing function
             */
            // Get userID
            userId = request.getUserId();
            logger.info("userId: " + userId);

            // Create Salt
            salt = Passwords.getNextSalt();
            logger.info("salt" + salt);

            // Convert user password into char array
            charPassword = request.getPassword().toCharArray();
            logger.info("password: " + charPassword);

            // Hash password with salt
            expectedHash = Passwords.hash(charPassword, salt);
            logger.info("expectedHash: " + expectedHash);

            /**
             * Creating response to user
             * Using ByteString.copyFrom in order to convert a byte[] --> ByteString
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
            logger.warning("Error thrown in hash: " + ex);
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
        logger.info("Validate Request: " + request);
        try {
            /**
             * Request from user and run through validation function
             */
            // Get password
            charPassword = request.getPassword().toCharArray();
            logger.info("Password: " + charPassword);
            // Get salt
            salt = request.getSalt().toByteArray();
            logger.info("Salt: " + salt);
            // Get expectedHash
            expectedHash = request.getExpectedHash().toByteArray();
            logger.info("Expected Hash: " + expectedHash);
            // Check if the password is valid or not
            isValidPassword = Passwords.isExpectedPassword(charPassword, salt, expectedHash);
            logger.info("Is Valid Password: " + isValidPassword);

            /**
             * Creating response to user
             * Sending back: isValidPassword
             */
            PasswordValidateResponse passwordValidateResponse = PasswordValidateResponse.newBuilder()
                    .setValidPassword(isValidPassword)
                    .build();
            logger.info("Validate Response: " + passwordValidateResponse);
            // Send to client
            responseObserver.onNext(passwordValidateResponse);
        } catch (RuntimeException ex) {
            System.out.println(ex);
            logger.warning("Error thrown in validate: " + ex);
        }
        // Commit to client
        responseObserver.onCompleted();
    }
}
