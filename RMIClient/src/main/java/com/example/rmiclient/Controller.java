/**
 * This is the Controller class which handles interactivity between the user (GUI) and the logic class Client.
 *
 * @author Alexandra Härnström
 * @version 1
 */
package com.example.rmiclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Client client;
    private ArrayList<Integer> numbers;

    public Controller() {
        client = new Client();
        numbers = new ArrayList<>();
    }
    @FXML
    private TextField textFieldPort;
    @FXML
    private TextField textFieldAddress;
    @FXML
    private Label labelResult;
    @FXML
    private ListView<Integer> listView;
    @FXML
    private TextField textFieldNumber;

    /**
     * This method adds one number to the list 'numbers'.
     * It updates the listView so the user can see which numbers s/he ahs added.
     */
    @FXML
    void addNumber() {
        int number = Integer.parseInt(textFieldNumber.getText());

        numbers.add(number);

        listView.getItems().add(number);
    }

    /**
     * This method sends the list 'numbers' to the Client object.
     * When the client has received the result from the server,
     * the result can be seen in the GUI.
     */
    @FXML
    void calculate() {
        int result = client.doAdditionOnServer(numbers);
        labelResult.setText("Result: " + result);
    }

    /**
     * This method retrieves user input: the address and port of the server to connect to.
     * It changes the view file from setUp.fxml to view.fxml.
     * The address and port are sent to the Client object.
     * @param event - The ActionEvent (triggered by button click) used to switch scene
     */
    public void setServerNameAndPort(ActionEvent event) {
        int port = Integer.parseInt(textFieldPort.getText());
        String host = textFieldAddress.getText();

        try {
            root = FXMLLoader.load(getClass().getResource("view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        client.connectToServer(port, host);
    }
}