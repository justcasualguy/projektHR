package services.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import models.Employee;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
         List<String> s = new ArrayList<>();
         List<String> qual = e.getQualifications();

         s.add("Test");
         TreeItem<String> root = new TreeItem<>(e.getName() + " " + e.getSurname());
         if(qual.size() == 0)
         {
             root.getChildren().add(new TreeItem<>("Brak Kwalifikacji"));
         }
         else
         {
             for(String item : qual)
             {
                 root.getChildren().add(new TreeItem<>(item));
             }
         }
         qualificationTreeView.setRoot(root);
     }




}

