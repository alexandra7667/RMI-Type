/**
 * This class initiates a TCP connection and creates a stub that a client can
 * connect to.
 * It implements the method in the Server interface.
 *
 * @author Alexandra Härnström
 * @version 1
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ServerInterface {

    /**
     * This method only calls the parent UnicastRemoteObject method which makes the stub available.
     * Oracle's definition of super constructor:
     * "Used for exporting a remote object with JRMP and obtaining a stub that communicates to the remote object."
     * @throws RemoteException
     */
    public Server() throws RemoteException {
        super();
    }

    /**
     * This method starts the server by putting a Server object into a Registry.
     * The client will contact the Registry to connect to the interface (get the stub)
     * and be able to use the server machine as an addition calculator.
     * The stub is the representation of the server.
     * @param port - The server port
     */
    public void startServer(int port) {

        try {
            ServerInterface serverInterface = new Server();

            Registry registry = LocateRegistry.createRegistry(port);

            registry.bind("Server", serverInterface);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Server started");
    }

    /**
     * This method is an implementation of the method in the ServerInterface.
     * It performs an addition with all number provided in an Integer list.
     * @param addList - The list with numbers
     * @return - The result of the addition (the sum of all numbers)
     */
    @Override
    public Integer addition(ArrayList<Integer> addList) {
        int result = 0;

        for(int number : addList) {
            result += number;
        }

        return result;
    }
}
