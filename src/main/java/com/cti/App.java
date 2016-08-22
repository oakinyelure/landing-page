package com.cti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

/**
 * @author ifeify
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // default port is 8080. Otherwise, use user supplied port
        // number if passed in as an argument
        String portNumber = System.getProperty("PORT");
        port(8080);
        if(portNumber != null) {
            port(Integer.parseInt(portNumber));
        }
        staticFileLocation("/html");

        Controller appController = new Controller();
        appController.handleNewEmail();

        exception(Exception.class, (e, request, response) -> {
            logger.error("An error occurred serving the request", e);
            logger.error("Request: {}", request.toString());
            logger.error("Response: {}", response.toString());
            response.status(500);
        });
        awaitInitialization();
    }
}
