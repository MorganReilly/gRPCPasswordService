package ie.gmit.ds;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PasswordServiceImpl extends PasswordServiceGrpc.PasswordServiceImplBase {
    // private ArrayList<PasswordRequest> passwordList;

    private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

    // Variables for checking password, hashing, salting
    private byte[] salt; // Use for return value: getNextSalt()
    private char[] charPassword; // Use for converting String password from request
    private byte[] expectedHash; // Use for params in isExpectedPassword()

//    public PasswordServiceImpl() {
//        this.passwordList = passwordList;
//    }

    @Override
    public void hash(UserInputRequest request, StreamObserver<BoolValue> responseObserver) {
        try {
            // Create Salt
            salt = Passwords.getNextSalt();
            // Convert user password into char[]
            charPassword = request.getPassword().toCharArray();
            // hash the password with the salt
            expectedHash = Passwords.hash(charPassword, salt);

            logger.info("Added new user info: " + request
                    + "\nsalt: " + salt
                    + "\ncharPassword: " + charPassword
                    + "\nexpectedHash" + expectedHash);

            responseObserver.onNext(UserInputRequest.newBuilder().setValue(true).build());
        } catch (RuntimeException ex) {
            responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
        }
        responseObserver.onCompleted();
    }


//    @Override
//    public void hash(PasswordRequest request, StreamObserver<BoolValue> responseObserver) {
//        try {
//            // Create Salt
//            salt = Passwords.getNextSalt();
//            // Convert user password into char[]
//            charPassword = request.getPassword().toCharArray();
//            // hash the password with the salt
//            expectedHash = Passwords.hash(charPassword, salt);
////
//            logger.info("Added new user info: " + request
//                    + "\nsalt: " + salt
//                    + "\ncharPassword: " + charPassword
//                    + "\nexpectedHash" + expectedHash);
////
//            responseObserver.onNext(PasswordRequest.newBuilder().setValue(true).build());
//        } catch (RuntimeException ex) {
//            responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
//        }
//        responseObserver.onCompleted();
//    }

//    private void checkPassword(String password) {
//        char[] tempPassword = password.toCharArray();
//        // generate salt
//        salt = Passwords.getNextSalt();
//
//        // hash password
//        hashedPassword = Passwords.hash(tempPassword, salt);
//        System.out.println(hashedPassword);
//        return hashedPassword;
//    }

}
