import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import generators.EmployeeGenerator;
import models.Employee;
import org.bson.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        String databaseUri = "mongodb+srv://user:user@cluster0-xxoxs.azure.mongodb.net/test?retryWrites=true&w=majority&maxIdleTimeMS=5000&ssl=true";
        String dbName = "Projekt";
        MongoDatabase database = DBConnector.getDatabase(databaseUri,dbName);
        MongoCollection<Document> collection = database.getCollection("Employees");


        collection.insertOne(EmployeeGenerator.generateEmployee().toDocument());
        MongoCursor<Document> cur = collection.find().iterator();
        while(cur.hasNext()){
           // Document doc = cur.next();
            System.out.println(cur.next());
        }
        System.out.println(collection.toString());



//        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//        collection.insertOne(doc);
    }
}
