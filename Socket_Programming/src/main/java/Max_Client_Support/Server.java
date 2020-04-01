package Max_Client_Support;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * Created by ravi on 16/3/20.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5056);

        while (true) {
            Socket socket = null;

            try {
                socket = serverSocket.accept();
                System.out.println("A new client is connected : " + socket);
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("Assigning new thread for this client");
                Thread thread = new Client(socket, dataInputStream, dataOutputStream);
                thread.start();

            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }

    }
}
