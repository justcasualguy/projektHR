package services.controllers;

import gui.MainStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Employee;
import models.User;
import services.LoginService;
import services.dbconnector.DBConnector;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneUserController implements Initializable {

//    MainSceneController(LoginController loginController){
//        whoIsLoggedIn.setText(loginController.ge);
//    }

private LoginController loginController;

    private Stage addEmployeeStage;
    private Stage tableViewStage;

    @FXML
    private Label whoIsLoggedIn;

    @FXML
    private Button logOutButton;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private Button removeUserButton;

    @FXML
    private Button editUserButton;

    @FXML
    private Button seekEmployeButton;

    @FXML
    private Button generateSomethingButton;

    @FXML
    private Label appNameLabel;

    @FXML
    private CheckBox nightMode;

    @FXML
    private TabPane tabPane;

    @FXML
    private PieChart pieChart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        whoIsLoggedIn.setText(LoginService.loggedUser.getUsername());
        final ObservableList<Employee> employees = FXCollections.observableArrayList();
        final ObservableList<User> admins = FXCollections.observableArrayList();

        employees.addAll(DBConnector.getCollectionAsList(Employee.class));
        admins.addAll(DBConnector.getCollectionAsList(User.class));
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Pracownicy", employees.size()),
                new PieChart.Data("Administratorzy", admins.size()));
        pieChart.setTitle("Ilość użytkowników aplikacji");
        pieChart.setData(pieChartData);
        pieChart.setLabelsVisible(true);
        pieChart.getData().forEach(data -> {
            String value = String.format("%.0f", (data.getPieValue()));
            Tooltip toolTip = new Tooltip(value);
            Tooltip.install(data.getNode(), toolTip);
        });
    }

    @FXML
    private void addEmployee() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/addEmployeeScene.fxml"));
        addEmployeeStage = new Stage();
        addEmployeeStage.initModality(Modality.WINDOW_MODAL);
        addEmployeeStage.initOwner(MainStage.mainStage.getScene().getWindow());
        addEmployeeStage.setScene(new Scene(root));
        addEmployeeStage.setTitle("Dodaj pracownika");
        addEmployeeStage.show();
        //MainStage.mainStage.setScene(new Scene(root));

    }
    @FXML
    public void seekEmployee() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/employeeTableView.fxml"));
        tableViewStage = new Stage();
        tableViewStage.initModality(Modality.WINDOW_MODAL);
        tableViewStage.initOwner(MainStage.mainStage.getScene().getWindow());
        tableViewStage.setScene((new Scene(root)));
        tableViewStage.setTitle("Pracownicy");
        tableViewStage.show();
    }
    @FXML
    private void logout() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/loginScene.fxml"));
        Scene scene = new Scene(root);
        MainStage.mainStage.setScene(scene);
       // MainStage.mainStage.show();

    }


    //<editor-fold desc="GS">
    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public Label getWhoIsLoggedIn() {
        return whoIsLoggedIn;
    }

    public void setWhoIsLoggedIn(Label whoIsLoggedIn) {
        this.whoIsLoggedIn = whoIsLoggedIn;
    }

    public Button getLogOutButton() {
        return logOutButton;
    }

    public void setLogOutButton(Button logOutButton) {
        this.logOutButton = logOutButton;
    }

    public Button getAddEmployeeButton() {
        return addEmployeeButton;
    }

    public void setAddEmployeeButton(Button addEmployeeButton) {
        this.addEmployeeButton = addEmployeeButton;
    }

    public Button getRemoveUserButton() {
        return removeUserButton;
    }

    public void setRemoveUserButton(Button removeUserButton) {
        this.removeUserButton = removeUserButton;
    }

    public Button getEditUserButton() {
        return editUserButton;
    }

    public void setEditUserButton(Button editUserButton) {
        this.editUserButton = editUserButton;
    }

    public Button getSeekEmployeButton() {
        return seekEmployeButton;
    }

    public void setSeekEmployeButton(Button seekEmployeButton) {
        this.seekEmployeButton = seekEmployeButton;
    }

    public Button getGenerateSomethingButton() {
        return generateSomethingButton;
    }

    public void setGenerateSomethingButton(Button generateSomethingButton) {
        this.generateSomethingButton = generateSomethingButton;
    }

    public Label getAppNameLabel() {
        return appNameLabel;
    }

    public void setAppNameLabel(Label appNameLabel) {
        this.appNameLabel = appNameLabel;
    }

    public CheckBox getNightMode() {
        return nightMode;
    }

    public void setNightMode(CheckBox nightMode) {
        this.nightMode = nightMode;
    }


    //</editor-fold>
}