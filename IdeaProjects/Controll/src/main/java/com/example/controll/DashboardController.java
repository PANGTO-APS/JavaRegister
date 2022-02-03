package com.example.controll;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private ImageView dashboardImageView;

    @FXML
    private TableView<UserController> userTable;

    @FXML
    private TableColumn<UserController, Integer> idCollumn;

    @FXML
    private TableColumn<UserController, String> firstnameCollumn;

    @FXML
    private TableColumn<UserController, String> lastnameCollumn;

    @FXML
    private TableColumn<UserController, String> usernameCollumn;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File dashboardFile = new File("images/icons8-dashboard-100.png");
        Image dashboardImage = new Image(dashboardFile.toURI().toString());
        dashboardImageView.setImage(dashboardImage);
    }
}
