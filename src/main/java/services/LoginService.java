package services;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import services.dbconnector.DBConnector;
import services.security.PasswordHasher;

import static com.mongodb.client.model.Filters.and;

public class LoginService {
    public static String loggedUser;
    public static boolean validateLogin(String username,String password){
        String passwordHashed = PasswordHasher.hashPassword(password);
        Document doc = DBConnector.getDatabase()
                .getCollection("Users")
                .find(and(
                        Filters.eq("username",username),
                        Filters.eq("password",PasswordHasher.hashPassword(password))
                        )
                ).first();



        if(doc!=null) {
            loggedUser = doc.get("username").toString();
            return true;
        }
        return false;
       // System.out.print(doc.toString());

    //return  doc!=null;
    }

}
