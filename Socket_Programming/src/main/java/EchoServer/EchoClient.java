package EchoServer;
import java.net.*;
import java.io.*;

/**
 * Created by ravi on 11/3/20.
 */
public class EchoClient {
    public static void main(String[] args) {
        try{
            System.out.println("Client Started");
            Socket socket = new Socket("localhost",9999);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String string = bufferedReader.readLine();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println(string);
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader1.readLine());

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
