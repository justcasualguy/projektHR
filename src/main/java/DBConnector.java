import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DBConnector {
    public static MongoDatabase getDatabase(String dbUri,String dbname){

        MongoClientURI uri = new MongoClientURI(dbUri);
        MongoClient mongoClient = new MongoClient(uri);
        return  mongoClient.getDatabase(dbname);
    }

}
