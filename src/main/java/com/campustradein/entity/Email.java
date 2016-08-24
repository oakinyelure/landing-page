package com.campustradein.entity;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Created by Olusegun on 8/8/2016.
 */
@Entity("emails")
@Indexes(
        @Index(value = "email", fields = @Field("email"))
)
public class Email {
    @Id
    private ObjectId id;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
