/**
 * This is the Main class which sets the GUI (fxml file) and associated Controller class.
 *
 * @author Alexandra Härnström
 * @version 1
 */

package com.example.rmiclient_3_3_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("setUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("RMI Client");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}