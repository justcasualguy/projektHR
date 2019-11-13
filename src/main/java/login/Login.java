package login;

import com.mongodb.client.model.Filters;
import dbconnector.DBConnector;
import org.bson.Document;
import security.PasswordHasher;

import static com.mongodb.client.model.Filters.and;

public class Login {



    public static boolean validateLogin(String username,String password){
        String passwordHashed = PasswordHasher.hashPassword(password);
        Document doc = DBConnector.getDatabase("Projekt")
                .getCollection("Users")
                .find(and(
                        Filters.eq("username",username),
                        Filters.eq("password",PasswordHasher.hashPassword(password))
                        )
                ).first();

    return  doc!=null;
    }


}
