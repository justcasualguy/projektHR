import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dbconnector.DBConnector;
import org.bson.Document;


public class Main {
    public static void main(String[] args) {
        String databaseUri = "mongodb+srv://user:user@cluster0-xxoxs.azure.mongodb.net/test?retryWrites=true&w=majority&maxIdleTimeMS=5000&ssl=true";
        String dbName = "Projekt";
        MongoDatabase database = DBConnector.getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection("Employees");


       //collection.insertOne(EmployeeGenerator.generateManEmployee().toDocument());


        MongoCursor<Document> cur = collection.find().iterator();
        while(cur.hasNext()){
           // Document doc = cur.next();
            System.out.println(cur.next().toJson());
        }



//        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//        collection.insertOne(doc);
    }
}
