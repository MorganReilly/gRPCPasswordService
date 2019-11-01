package ie.gmit.ds;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException; 
import java.util.logging.Logger;

public class PasswordServer {
    /**
     * Variables
     */
    private Server grpcServer;
    private static final Logger logger = Logger.getLogger(PasswordServer.class.getName());
    private static final int PORT = 50551;

    /**
     * Server startup and shutdown methods
     *
     * @throws IOException
     */
    // Start server
    private void start() throws IOException {
        grpcServer = ServerBuilder.forPort(PORT)
                .addService(new PasswordServiceImpl())
                .build()
                .start();
        logger.info(String.format("Server started, listening on port: %s", PORT));
    }

    /**
     * Stop server
     */
    private void stop() {
        if (grpcServer != null) {
            grpcServer.shutdown();
        }
    }

    /**
     * Await termination on main thread. grpc library uses daemon threads
     *
     * @throws InterruptedException
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (grpcServer != null) {
            grpcServer.awaitTermination();
        }
    }

    /**
     * Server runner
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final PasswordServer passwordServer = new PasswordServer();
        passwordServer.start();
        passwordServer.blockUntilShutdown();
    }
}

