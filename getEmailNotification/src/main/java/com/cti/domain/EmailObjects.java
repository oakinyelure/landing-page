package com.cti.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Olusegun on 8/8/2016.
 */
@Entity
public class EmailObjects {

    @Id
    private ObjectId id;
    private String email;
    private String fullName;

    public EmailObjects(){}

       public EmailObjects(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
