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

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        DBConnector.connect("Projekt");
//        DBConnector.addCollection("Users");
      //  DBConnector.getDatastore().save(new User("admin","admin","email","admin"));
        Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        //System.out.println(DBConnector.getCollectionAsList(Employee.class).toString());

        Scene scene = new Scene(root);
        mainStage= MainStage.mainStage;
        mainStage.setScene(scene);
        mainStage.setTitle("Logowanie");
        //stage.setScene(scene);
        mainStage.show();
    }


}
