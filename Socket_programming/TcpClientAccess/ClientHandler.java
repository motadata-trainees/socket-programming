package TcpClientAccess;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;


public class ClientHandler extends Thread {
    public static int count = 0;
    public ClientHandler(int count){
        super("ServerThread");
        this.count = count;
    }
    public void run(){

            try {
                System.out.println("Client " + count +" started");
                Socket client =  new Socket("localhost",5555);
                String command = "hello";
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                out.println(command);

            }catch (Exception e){
                e.printStackTrace();
            }



    }

}
