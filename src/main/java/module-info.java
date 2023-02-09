module com.example.insurancepolicyprogram {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires java.sql;


    opens com.example.insurancepolicyprogram to javafx.fxml;
    exports com.example.insurancepolicyprogram;
}