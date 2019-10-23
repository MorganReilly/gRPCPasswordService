package ie.gmit.ds;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordClient {
    /**
     * Client initialisation
     * Using blocking stubs -- Asynchronous and Synchronous
     */
    private static final Logger logger = Logger.getLogger(PasswordClient.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub syncPasswordService;

    /**
     * Variables
     * HOST, PORT -- Connection
     */
    private static final String HOST = "localhost";
    private static final int PORT = 50551;

    /**
     * Client store variables
     * userId
     * password
     * salt
     * expectedHash
     */
    private int userId;
    private String password;
    private byte[] salt;
    private byte[] expectedHash;

    /**
     * Constructor
     *
     * @param host
     * @param port
     */
    public PasswordClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getExpectedHash() {
        return expectedHash;
    }

    public void setExpectedHash(byte[] expectedHash) {
        this.expectedHash = expectedHash;
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
    public void Hash(int userId, String password) {
        UserInputRequest userInputRequest;
        logger.info("Hash Request\nUserId: " + userId + "\nPassword: " + password); // Logging request
        try {
            // Create request
            userInputRequest = UserInputRequest.newBuilder()
                    .setUserId(userId)
                    .setPassword(password)
                    .build();
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "Hash Request Failed", ex.getStatus());
            return;
        }
        // Send request using stub
        UserInputResponse userInputResponse = syncPasswordService.hash(userInputRequest);
        // Logging response
        logger.info("Hash Response\nUserId: " + userId
                + "\nSalt: " + userInputResponse.getExpectedHash().toByteArray()
                + "\nHashed Password: " + userInputResponse.getSalt().toByteArray());

        // Set all global variables
        setUserId(userId);
        setPassword(password);
        setSalt(userInputResponse.getSalt().toByteArray());
        setExpectedHash(userInputResponse.getExpectedHash().toByteArray());
    }

    /**
     * Validate password
     */
    public void Validate(String password, byte[] salt, byte[] expectedHash) {
        PasswordValidateRequest passwordValidateRequest;
        try {
            // Create request
            passwordValidateRequest = PasswordValidateRequest.newBuilder()
                    .setPassword(password)
                    .setSalt(ByteString.copyFrom(salt))
                    .setExpectedHash(ByteString.copyFrom(expectedHash))
                    .build();
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "Validate Request Failed", ex.getStatus());
            return;
        }
        // Send response using stub
        PasswordValidateResponse passwordValidateResponse = syncPasswordService.validate(passwordValidateRequest);
        logger.info("Validate Request\nPassword: " + password + "\nSalt: " + salt + "\nHashed Password: " + expectedHash); // Logging request
        logger.info("Validate Response\nIs Valid Password: " + passwordValidateResponse.getValidPassword()); // Logging response
    }

    /**
     * Main -- Client Runner
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        PasswordClient passwordClient = new PasswordClient(HOST, PORT);

        try {
            passwordClient.Hash(001, "password");
            passwordClient.Validate(passwordClient.getPassword(),
                    passwordClient.getSalt(),
                    passwordClient.getExpectedHash());

//            passwordClient.Validate("notThePassword",
//                    passwordClient.getSalt(),
//                    passwordClient.getExpectedHash()); // Used for testing
        } finally {
            // Thread.currentThread().join();
            passwordClient.shutdown();
        }
    }
}
