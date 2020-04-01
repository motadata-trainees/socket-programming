package trivialserver;
import java.util.*;
import java.lang.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by ravi on 13/3/20.
 */
public class DataServer {
    public static void main(String[] args) {

        try{
            ServerSocket listener = new ServerSocket(8888);
            System.out.println("Data Server is running");
            while(true)
            {
                try
                {
                    Socket socket = listener.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    out.println(new Date().toString());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
