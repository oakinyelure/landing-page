package com.cti.connectin;

import com.cti.domain.EmailObjects;
import com.cti.domain.EmailObjects;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by Olusegun on 8/9/2016.
 */

//Method connects to Mongo DB
public class DbConnection {

    MongoClient databaseLocation = new MongoClient("localhost", 27017);//Address subject to change
    Datastore beforeLaunch = new Morphia().createDatastore(databaseLocation, "deploymentEmailAddresses");//This creates a document

    //This creates the collection using emailObjects.java to convert Java objects to mongo Json format
   public String storeEmailAddress(EmailObjects email) {
       beforeLaunch.save(email);
       return "null";
   }
}
