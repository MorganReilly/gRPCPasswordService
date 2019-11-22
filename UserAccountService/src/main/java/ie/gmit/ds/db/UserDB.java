package ie.gmit.ds.db;

import ie.gmit.ds.api.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDB {
    /**
     * Data persistence
     * Using a hash-map to store the user and data
     */
    private static HashMap<Integer, User> usersMap = new HashMap<>();

    /**
     * Use this for initial testing
     */
//    static {
//        User newUser0 = new User(6, "Morgan", "m@mail.com", "1234");
//        User newUser1 = new User(7, "Cathal", "c@mail.com", "5555");
//        User newUser2 = new User(8, "Kevin", "k@mail.com", "11111");
//        usersMap.put(newUser0.getUserId(), newUser0);
//        usersMap.put(newUser1.getUserId(), newUser1);
//        usersMap.put(newUser2.getUserId(), newUser2);
//    }
    /**
     * Get all users
     *
     * @return
     */
    public static List<User> getUsers() {
        return new ArrayList<>(usersMap.values());
    }

    /**
     * Get a user by Id
     *
     * @param id
     * @return
     */
    public static User getUser(int id) {
        return usersMap.get(id);
    }

    /**
     * Create a user by Id
     *
     * @param userId
     * @param user
     */
    public static void createUser(int userId, User user) {
        usersMap.put(userId, user);
    }

    /**
     * Update user by Id
     *
     * @param userId
     * @param user
     */
    public static void updateUser(int userId, User user) {
        usersMap.put(userId, user);
    }

    /**
     * Delete user by Id
     *
     * @param userId
     */
    public static void deleteUser(int userId) {
        usersMap.remove(userId);
    }
}
