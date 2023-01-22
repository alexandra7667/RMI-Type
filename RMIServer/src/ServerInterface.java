/**
 * This is the Server interface which connects the Client and the Server.
 * It lists the method overridden in the Server.
 * The client can use the Server interface as any object when connected.
 *
 * @author Alexandra Härnström
 * @version 1
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterface extends Remote {

    Integer addition(ArrayList<Integer> addList) throws RemoteException;

}