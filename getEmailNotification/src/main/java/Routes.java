/**
 * Created by Olusegun on 8/8/2016.
 */
import com.cti.connectin.DbConnection;
import com.cti.domain.EmailObjects;
import com.cti.domain.EmailObjects;
import freemarker.template.Configuration;

import static com.cti.util.JsonUtil.*;
import static com.cti.util.JsonUtil.*;
import static spark.Spark.*;


public class Routes {

    public static DbConnection connectMongo = new DbConnection();
    public static void main(String[] args){
        staticFileLocation("/public");
        Configuration loaderConfig = new Configuration();
        loaderConfig.setClassForTemplateLoading(Routes.class, "/public");

        get("/", (req, res) -> {
            return loaderConfig.getTemplate("/emailNotification.ftl");
        });

        //Data get sents to MongoDb
        post("/save", (req, res) -> {
           res.type("application/json");
            EmailObjects email = fromJson(req.body(), EmailObjects.class);
             return connectMongo.storeEmailAddress(email);
        }, json());

        //Not sure if the method actually works. Not tested yet
        get("/throwexception", (request, response) -> {
            throw new ClassNotFoundException();
        });

        exception(ClassNotFoundException.class, (e, request, response) -> {
            response.status(404);
            response.body("We are currently working on this page");
        });
    }
}
