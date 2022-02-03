module sample.usermanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.usermanager to javafx.fxml;
    exports sample.usermanager;
}