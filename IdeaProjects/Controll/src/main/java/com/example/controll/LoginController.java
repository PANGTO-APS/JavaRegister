package com.example.controll;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("images/my_logo.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("images/icons8-lock-480.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void loginButtonOnAction(ActionEvent event) {

        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            validateLogin();
            //loginMessageLabel.setText("ＩＤまたはパスワードが正しくありません");
        }else{
            loginMessageLabel.setText("ユーザーIDとパスワードを入力してください");
        }
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextField.getText() + "' AND password = '" + enterPasswordField.getText() + "'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while(queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    goToDashboard();
                    loginMessageLabel.setText("ログイン出来ました！");
                }else{
                    loginMessageLabel.setText("ＩＤまたはパスワードが正しくありません");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccountForm(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("register.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 520, 400);
            registerStage.initStyle(StageStyle.DECORATED);
            registerStage.setScene(scene);
            registerStage.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void goToDashboard(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("dashboard.fxml"));
            Stage dashboardStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 520, 400);
            dashboardStage.initStyle(StageStyle.DECORATED);
            dashboardStage.setScene(scene);
            dashboardStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}