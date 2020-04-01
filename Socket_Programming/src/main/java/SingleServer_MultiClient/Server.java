package SingleServer_MultiClient;

import ThreadServer.Capitalizer;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ravi on 13/3/20.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket listener = new ServerSocket(11111);
            System.out.println("The UpperCase server is running...");
            Socket socket = listener.accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (in.hasNextLine()) {
                out.println(in.nextLine().toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
