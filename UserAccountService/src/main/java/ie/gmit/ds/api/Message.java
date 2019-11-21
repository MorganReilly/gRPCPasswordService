package ie.gmit.ds.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }
}
