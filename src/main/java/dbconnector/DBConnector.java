package dbconnector;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DBConnector {
    private static String mongoAtlasClusterUri = "mongodb+srv://user:user@cluster0-xxoxs.azure.mongodb.net/test?retryWrites=true&w=majority&maxIdleTimeMS=5000&ssl=true";
    private static MongoClient mongoAtlasClient = new MongoClient(new MongoClientURI(mongoAtlasClusterUri));

    public static MongoDatabase getDatabase(String dbName){
        return  mongoAtlasClient.getDatabase(dbName);
    }

}
