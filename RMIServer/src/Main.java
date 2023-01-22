/**
 * This is the Main class of the server.
 * It takes one argument which is the port of the server and instantiates a Server object.
 *
 * @author Alexandra Härnström
 * @version 1
 */

public class Main {
    public static void main(String[] args) {

        int port = 2000;

        if(args[0] != null) {
            port = Integer.parseInt(args[0]);
        }

        try {
            Server server = new Server();
            server.startServer(port);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
