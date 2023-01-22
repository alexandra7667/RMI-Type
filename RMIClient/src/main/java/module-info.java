module com.example.rmiclient_3_3_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.rmiclient_3_3_1 to javafx.fxml;
    exports com.example.rmiclient_3_3_1;
}