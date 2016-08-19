/**
 * Created by Olusegun on 8/8/2016.
 */
import com.cti.connectin.DbConnection;
import com.cti.domain.EmailObjects;
import freemarker.template.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.cti.util.JsonUtil.*;
import static spark.Spark.*;


public class Routes {
    private static final Logger logger = LoggerFactory.getLogger(Routes.class);

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

        exception(Exception.class, (e, request, response) -> {
            logger.error("An error occurred serving the request", e);
            logger.error("Request: {}", request.toString());
            logger.error("Response: {}", response.toString());
        });
    }
}
