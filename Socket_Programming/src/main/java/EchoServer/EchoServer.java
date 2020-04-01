package EchoServer;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

/**
 * Created by ravi on 11/3/20.
 */
public class EchoServer {
    public static void main(String args[]){
        try{
            System.out.println("Waiting for Client >>>>>>");
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            System.out.println("Connection Established");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String string = bufferedReader.readLine();
            System.out.println("Client says "+string);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("Server Says Back "+string);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
