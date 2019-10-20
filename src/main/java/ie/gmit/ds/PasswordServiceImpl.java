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

    private boolean isValidPassword; // Use for checking if password is valid or not

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
            UserInputResponse userInputResponse = UserInputResponse.newBuilder()
                    .setUserId(userId)
                    .setExpectedHash(expectedHash.toString())
                    .setSalt(salt.toString())
                    .build();
            // Send to client
            responseObserver.onNext(userInputResponse);
        } catch (RuntimeException ex) {
            System.out.println(ex);
            logger.info("Error thrown in hash: " + ex);
        }
        // Commit to client
        responseObserver.onCompleted();
    }

    @Override
    public void validate(PasswordValidateRequest request, StreamObserver<PasswordValidateResponse> responseObserver) {
        System.out.println(request);
        try {
            /**
             * Request from user and run through validation function
             */
            // Get password
            charPassword = request.getPassword().toCharArray();
            System.out.println("charPassword: " + charPassword);
            logger.info("charPassword: " + charPassword);

            // TODO:  Get salt -- do with or without request?
            salt = request.getSalt().getBytes();
            System.out.println("Created Salt: " + salt);
            logger.info("Created Salt: " + salt);

            isValidPassword = Passwords.isExpectedPassword(charPassword, salt, expectedHash);
            System.out.println("valid password: " + isValidPassword);
            logger.info("Valid password: " + isValidPassword);

            /**
             * Creating response to user
             * Sending back: isValidPassword
             */
            // Creating response
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
