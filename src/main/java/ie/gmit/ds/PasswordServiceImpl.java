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
     * rpc - Hash
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void hash(UserInputRequest request, StreamObserver<UserInputResponse> responseObserver) {
        // Logging request
        logger.info("Hash Request\nUserId: " + request.getUserId() + "\nPassword: " + request.getPassword());
        try {
            /**
             * Request from user and run through hashing function
             */
            // Get userID
            userId = request.getUserId();
            // Create Salt
            salt = Passwords.getNextSalt();
            // Convert user password into char array
            charPassword = request.getPassword().toCharArray();
            // Hash password with salt
            expectedHash = Passwords.hash(charPassword, salt);
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
            // Logging response
            logger.info("Hash Response\nUserId: " + userInputResponse.getUserId()
                    + "\nSalt: " + userInputResponse.getSalt()
                    + "\nHashed Password: " + userInputResponse.getExpectedHash());
            // Send to client
            responseObserver.onNext(userInputResponse);
        } catch (RuntimeException ex) {
            logger.warning("Error thrown in Hash: " + ex);
        }
        // Commit to client
        responseObserver.onCompleted();
    }

    /**
     * rpc - Validate
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void validate(PasswordValidateRequest request, StreamObserver<PasswordValidateResponse> responseObserver) {
        // Logging request
        logger.info("Validate Request\nPassword: " + request.getPassword()
                + "\nSalt: " + request.getSalt()
                + "\nHashed Password: " + request.getPassword());
        try {
            /**
             * Request from user and run through validation function
             */
            // Get password
            charPassword = request.getPassword().toCharArray();
            // Get salt
            salt = request.getSalt().toByteArray();
            // Get expectedHash
            expectedHash = request.getExpectedHash().toByteArray();
            // Check if the password is valid or not
            isValidPassword = Passwords.isExpectedPassword(charPassword, salt, expectedHash);
            /**
             * Creating response to user
             * Sending back: isValidPassword
             */
            PasswordValidateResponse passwordValidateResponse = PasswordValidateResponse.newBuilder()
                    .setValidPassword(isValidPassword)
                    .build();
            // Logging response
            logger.info("Validate Response\nIs Valid Password: " + passwordValidateResponse.getValidPassword());
            // Send to client
            responseObserver.onNext(passwordValidateResponse);
        } catch (RuntimeException ex) {
            System.out.println(ex);
            logger.warning("Error thrown in Validate: " + ex);
        }
        // Commit to client
        responseObserver.onCompleted();
    }
}
