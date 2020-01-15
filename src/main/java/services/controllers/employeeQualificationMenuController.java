package services.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import models.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class employeeQualificationMenuController implements Initializable
{
    @FXML
    private TreeView<String> qualificationTreeView;

    @FXML
    private Label testTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

     public void sendEmployee(Employee e)
     {
         TreeItem<String> root = new TreeItem<>(e.getName() + " " + e.getSurname());
         TreeItem<String> itemChild = new TreeItem<>(e.getContractType());
         TreeItem<String> itemChild2 = new TreeItem<>(e.getEmployedSince());
         TreeItem<String> itemChild3 = new TreeItem<>(e.getSalary());
         root.getChildren().addAll(itemChild, itemChild2, itemChild3);
         qualificationTreeView.setRoot(root);
     }




}

