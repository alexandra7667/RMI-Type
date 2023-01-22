module com.example.rmiclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.rmiclient to javafx.fxml;
    exports com.example.rmiclient;
}