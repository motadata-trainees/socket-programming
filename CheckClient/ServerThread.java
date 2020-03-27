package CheckClient;

import java.io.*;
import java.net.Socket;

/**
 * Created by nilesh on 13/3/20.
 */

public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Client Accepted");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            System.out.println(br.readLine());

            PrintWriter wr = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()), true);
            wr.println("Welcome to Socket Programming ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
