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

    static {
        User newUser0 = new User(1, "Morgan", "m@mail", "1234");
        User newUser1 = new User(2, "Cathal", "c@mail", "1111");
        User newUser2 = new User(3, "Kevin", "k@mail", "2222");
        usersMap.put(newUser0.getUserId(), newUser0);
        usersMap.put(newUser1.getUserId(), newUser1);
        usersMap.put(newUser2.getUserId(), newUser2);

//        usersMap.put(1, new User(1, "Morgan", "m@mail", "1234")); // This way uses an integer value as the index and then holds user info

    }

    public static List<User> getUsers() {
        return new ArrayList<User>(usersMap.values());
    }

    public static User getUser(int id) {
        return usersMap.get(id);
    }


    public static void createUser(int userId, User user) {
        usersMap.put(userId, user);
    }

    public static void updateUser(int userId, User user) {
        usersMap.put(userId, user);
    }

    public static void deleteUser(int userId) {
        usersMap.remove(userId);
    }
}
