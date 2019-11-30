import gui.MainStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.dbconnector.DBConnector;

public class Main extends Application {
    public Stage mainStage = new Stage();

    public static void main(String[] args) {

//        String databaseUri = "mongodb+srv://user:user@cluster0-xxoxs.azure.mongodb.net/test?retryWrites=true&w=majority&maxIdleTimeMS=5000&ssl=true";
//        String dbName = "Projekt";
//        MongoDatabase database = DBConnector.getDatabase(databaseUri,dbName);
//        MongoCollection<Document> collection = database.getCollection("Employees");
//
//
//        collection.insertOne(EmployeeGenerator.generateManEmployee().toDocument());
//
//
//        MongoCursor<Document> cur = collection.find().iterator();
//        while(cur.hasNext()){
//           // Document doc = cur.next();
//            System.out.println(cur.next());
//        }



//        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//        collection.insertOne(doc);
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        DBConnector.connect("Projekt");
        Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));


        Scene scene = new Scene(root);
        mainStage= MainStage.mainStage;
        mainStage.setScene(scene);
        stage.setTitle("FXML Welcome");
        //stage.setScene(scene);
        mainStage.show();
    }


}
