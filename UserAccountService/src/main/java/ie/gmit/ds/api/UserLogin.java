package ie.gmit.ds.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

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
 *
 * Using this class to allow the user to login
 */
public class UserLogin {
    @NotNull
    private int userId;

    @NotBlank
    private String password;

    /**
     * No arg constructor
     * Needed for Jackson deserialisation
     */
    public UserLogin() {
    }

    @JsonProperty
    public int getUserId() {
        return userId;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }
}
