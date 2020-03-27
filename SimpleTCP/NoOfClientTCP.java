package SimpleTCP;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by nilesh on 17/3/20.
 */
public class NoOfClientTCP {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(2123)) {
            Socket[] clients = new Socket[65535];
            for (int i = 0; i < clients.length; i++) {
                clients[i] = new Socket("localhost", 2123);
               // System.out.printf("Client %2d: " + clients[i] + "%n", i);
                System.out.println("Client "+i+" "+clients[i]);

               // server.accept();
                clients[i].close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
