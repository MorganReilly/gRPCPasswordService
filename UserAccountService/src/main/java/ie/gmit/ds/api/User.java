package ie.gmit.ds.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Representation Class
 * <p>
 * Represents the JSON being consumed
 * <p>
 * Simple POJO - Plain Old Java Object
 * <p>
 * Immutable - Can't be changed - Getters only
 * <p>
 * Uses Javabeans standard for 'id' and 'content'
 * <p>
 * In this case it's: 'id' and 'User'
 */
public class User {

    @NotNull
    private int userId;

    @NotBlank @Length(min = 2, max = 255)
    private String userName;

    @Pattern(regexp = ".+@.+\\.[a-z]+")
    private String email;

    @NotBlank @Length(min=2, max = 15)
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

    @JsonProperty
    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
