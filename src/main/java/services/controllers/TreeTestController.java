package services.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class TreeTestController implements Initializable {

    @FXML
    private TreeView<String> tree;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TreeItem<String> item = new TreeItem<>("costam");

        tree.setRoot(item);

    }
}
