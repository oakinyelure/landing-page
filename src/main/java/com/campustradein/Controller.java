package com.campustradein;

import com.campustradein.entity.Email;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import static spark.Spark.*;

/**
 * Created by Olusegun on 8/8/2016.
 */
public class Controller {
    private MongoClient mongoClient;
    private Datastore dataStore;
    private Gson gson = new Gson();

    public Controller() {
        // TODO: get mongo config from yaml file or properties file
        mongoClient = new MongoClient("localhost", 27017);//Address subject to change
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.cti.entity");
        dataStore = morphia.createDatastore(mongoClient, "early-adopters");//document name is early-adopters
    }

    public void handleNewEmail() {
        post("/save/:email", (request, response) -> {
            String emailAddress = request.params(":email");

            if(emailAddress == null || emailAddress.isEmpty()) {
                response.status(400);
                return null;
            }
            Email email = new Email();
            email.setEmail(emailAddress);
            dataStore.save(email);
            response.status(200);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("result", "ok");
            return gson.toJson(jsonObject);
        });
    }
}
