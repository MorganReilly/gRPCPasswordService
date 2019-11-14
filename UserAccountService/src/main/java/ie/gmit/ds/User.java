package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private int userId;
    private String userName;
    private String email;
    private String password;

    /**
     * No arg constructor
     * Needed for Jackson deserialisation
     */
    public User() {
    }

    /**
     * 4 Param constructor
     *
     * @param userId
     * @param userName
     * @param email
     * @param password
     */
    public User(int userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    /**
     * Note: This class only has getters
     * No setters
     * This is because we want our class to be immutable
     * Each getter needs @JsonProperty annotation
     */
    @JsonProperty
    public int getUserId() {
        return userId;
    }

    @JsonProperty
    public String getUserName() {
        return userName;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }
}
