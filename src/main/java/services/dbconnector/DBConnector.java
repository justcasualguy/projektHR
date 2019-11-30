package services.dbconnector;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.HashMap;
import java.util.Map;

public class DBConnector {
    private static String mongoAtlasClusterUri = "mongodb+srv://user:user@cluster0-xxoxs.azure.mongodb.net/test?retryWrites=true&w=majority&ssl=true";
    private static final MongoClient mongoAtlasClient = new MongoClient(new MongoClientURI(mongoAtlasClusterUri));
    private static  MongoDatabase database;
    private static Map<String, MongoCollection> collections =  new HashMap<>();

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void connect(String dbName){
        database = mongoAtlasClient.getDatabase(dbName);
    }
//    public static boolean addCollection(String collectionName){
//
//    }
    public static MongoDatabase getDatabase(String dbName){
        return  mongoAtlasClient.getDatabase(dbName);
        //mongoAtlasClient.
    }

}
