/**
 * This class handles the logic of the program.
 * It connects to the shared Server interface and communicates with it.
 *
 * @author Alexandra Härnström
 * @version 1
 */

package com.example.rmiclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    private ServerInterface serverInterface;

    /**
     * This method connects to the Server interface.
     * @param port - The server port
     * @param host - The server address
     */
    public void connectToServer(int port, String host) {

        try {
            Registry registry = LocateRegistry.getRegistry(host, port);

            serverInterface = (ServerInterface) registry.lookup("Server");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method sends a list with numbers to the Server interface to calculate.
     * The Server interface does the calculation and returns the result.
     * @param addList - The list with the numbers to add
     * @return - The result of the addition
     */
    public Integer doAdditionOnServer(ArrayList<Integer> addList) {
        Integer result = 0;
        try {
            result = serverInterface.addition(addList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}


