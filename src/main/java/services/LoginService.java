package services;

import models.User;
import org.bson.Document;
import org.mongodb.morphia.query.Query;
import services.dbconnector.DBConnector;
import services.security.PasswordHasher;

public class LoginService {
    public static String loggedUser;
    public static boolean validateLogin(String username,String password){
        String passwordHashed = PasswordHasher.hashPassword(password);
        Document doc = null;

        Query<User> query  = DBConnector
                .getDatastore()
                .createQuery(User.class)
                .field("username").equal(username)
                .field("password").equal(PasswordHasher.hashPassword(password));


        if(query.get()!=null) {
            loggedUser = query.get().getUsername();
            return true;
        }
        return false;

    }

}
