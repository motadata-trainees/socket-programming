package TcpClientAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Server {
    static int i = 1;
    public static void main(String args[]) throws IOException {
        System.out.println("Waiting for client.");
        ServerSocket server = new ServerSocket(5555);
        while(true){
            try {
                Socket client = server.accept();
                System.out.println("Connection established");
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String result = input.readLine();
                System.out.println(result + " " + i);
                i = i + 1;
                TimeUnit.MILLISECONDS.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }
}
