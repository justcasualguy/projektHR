package services.generators;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorGenerator
{
    public static void errorMessage(String error)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Wystąpił nieoczekiwany błąd!");
        window.setMinWidth(300);

        Label errorMessage = new Label();
        errorMessage.setText(error);
        Button close = new Button("Zamknij");
        close.setOnAction(e -> window.close());

        VBox v = new VBox(20);
        v.getChildren().addAll(errorMessage, close);
        v.setAlignment(Pos.CENTER);


        Scene scene = new Scene(v);
        window.setScene(scene);
        window.showAndWait();

    }
}
