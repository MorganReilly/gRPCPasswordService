package ie.gmit.ds.client;

import com.google.protobuf.ByteString;
import ie.gmit.ds.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

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

    /**
     * Variables
     * HOST, PORT -- Connection
     */
    private static final String HOST = "localhost";
    private static final int PORT = 50551;

    /**
     * Client store variables
     * userId
     * userName
     * email
     * password
     * salt
     * expectedHash
     */
    private int userId;
    private String userName;
    private String email;
    private String password;
    private byte[] salt; // TODO: Convert to String later ?
    private byte[] expectedHash; // TODO: Convert to String later ?

    /**
     * Constructor
     *
     * @param host
     * @param port
     */
    public UserClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        syncPasswordService = PasswordServiceGrpc.newBlockingStub(channel);
    }

    /**
     * Getters / Setters
     */
    public static Logger getLogger() { return logger; }

    public ManagedChannel getChannel() { return channel; }

    public static String getHOST() { return HOST; }

    public static int getPORT() { return PORT; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public byte[] getSalt() { return salt; }

    public void setSalt(byte[] salt) { this.salt = salt; }

    public byte[] getExpectedHash() { return expectedHash; }

    public void setExpectedHash(byte[] expectedHash) { this.expectedHash = expectedHash; }

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

    public static void main(String[] args) throws InterruptedException{
        UserClient userClient = new UserClient(HOST, PORT);

        try {
            // Test 1 -- Should pass --> Return true
            userClient.Hash(001, "password");
            userClient.Validate(userClient.getPassword(),
                    userClient.getSalt(),
                    userClient.getExpectedHash());

            // Test 2 -- Should fail --> Return false
            userClient.Hash(002, "fuckGRPC");
            userClient.Validate("fucGEEORPEECEE",
                    userClient.getSalt(),
                    userClient.getExpectedHash());
        } finally {
            userClient.shutdown();
        }
    }
}
