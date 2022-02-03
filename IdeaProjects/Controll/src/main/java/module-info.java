module com.example.controll {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.controll to javafx.fxml;
    exports com.example.controll;
}