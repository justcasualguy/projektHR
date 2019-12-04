import com.mongodb.MongoClient;
import models.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import services.dbconnector.DBConnector;
import services.security.PasswordHasher;

import java.util.List;



public class Test {



    public static void main(String[] args) {

         class UserDAO extends BasicDAO<User,String>{
            public UserDAO(Morphia morphia, MongoClient mongoClient, String dbName){
                super(mongoClient,morphia,dbName);
            }
        }

        DBConnector.connect("Projekt");

        Morphia morphia = new Morphia();
        UserDAO dao = new UserDAO(morphia,DBConnector.getMongoAtlasClient(),"Projekt");

        morphia.mapPackage("models");
        Datastore datastore = morphia.createDatastore(DBConnector.getMongoAtlasClient(),"Projekt");



        QueryResults<User> users = dao.find();
        List<User> userss = DBConnector.getCollectionAsList(User.class);

        Query<User> query  = DBConnector
                .getDatastore()
                .createQuery(User.class)
                .field("username").equal("test")
                .field("password").equal(PasswordHasher.hashPassword("test"));
        System.out.println(query.get());






       //datastore.save(new User("newuser","password","email","user"));


//       userss = query.asList();
//
//        for(User u : userss)
//            System.out.println(u);
    }

}
