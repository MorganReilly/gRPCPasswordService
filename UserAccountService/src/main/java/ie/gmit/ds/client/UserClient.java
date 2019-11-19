package ie.gmit.ds.client;

import java.util.logging.Logger;
import io.grpc.ManagedChannel;

public class UserClient {

    /**
     * Client initialisation
     * Using blocking stubs -- Asynchronous and Synchronous
     */
    private static final Logger logger = Logger.getLogger(UserClient.class.getName());
    private final ManagedChannel channel;

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
}
