import com.mongodb.client.MongoCollection;
import dbconnector.DBConnector;
import login.Login;
import models.User;
import org.bson.Document;
import security.PasswordHasher;

public class Test {


    public static void main(String[] args) {
        System.out.println(Login.validateLogin("adam","adam"));
        MongoCollection<Document> collection = DBConnector.getDatabase("Projekt").getCollection("Users");


        collection.insertOne(new User("adam", PasswordHasher.hashPassword("adam"),"admin").toDocument());
        System.out.println("After " + Login.validateLogin("adam","adam"));
    }

}
