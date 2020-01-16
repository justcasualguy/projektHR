package services.dbconnector;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.List;

public class DBConnector {
    private static String mongoAtlasClusterUri = "mongodb+srv://user:user@cluster0-xxoxs.azure.mongodb.net/test?retryWrites=true&w=majority&ssl=true";
    private static final MongoClient mongoAtlasClient = new MongoClient(new MongoClientURI(mongoAtlasClusterUri));
    private static  MongoDatabase database;
    private static Morphia morphia;
    private static  Datastore datastore;

    public static <T> List<T> getCollectionAsList(Class<T> pojoClass){
        Query<T> query = datastore.createQuery(pojoClass);
        return query.asList();
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void connect(String dbName){
        morphia = new Morphia();
        morphia.mapPackage("models");
        datastore = morphia.createDatastore(mongoAtlasClient,dbName);
        database = mongoAtlasClient.getDatabase(dbName);

    }
//
    public static String getMongoAtlasClusterUri() {
        return mongoAtlasClusterUri;
    }


    public static Morphia getMorphia() {
        return morphia;
    }

    public static Datastore getDatastore() {
        return datastore;
    }

    public static MongoClient getMongoAtlasClient() {
        return mongoAtlasClient;
    }

    public static MongoDatabase getDatabase(String dbName){

        return  mongoAtlasClient.getDatabase(dbName);
    }


}
