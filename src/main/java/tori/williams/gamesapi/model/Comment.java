package tori.williams.gamesapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;

public class Comment {

    @JsonProperty("user")
    private String user;

    @JsonProperty("message")
    private String message;

    @JsonProperty("dateCreated")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateCreated;

    @JsonProperty("like")
    private int rating;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

