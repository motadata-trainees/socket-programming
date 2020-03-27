package ChatRoom;
/**
 * Created by nilesh on 12/3/20.
 */
import java.net.*;
import java.io.*;

public class MultiRequest {
    static int count=0;
    public static void main(String[] args) {
        ServerSocket Sersoc = null;
        Socket clientSocket = null;

        // String inputLine=null;
        // BufferedReader input=null;
        PrintWriter output = null;
        try {
            Sersoc = new ServerSocket(8898);
            System.out.println("Ready for Listen you");
            //PrintWriter

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        while (true)
        {
            try {
               // clientSocket.setSoTimeout(3);
                clientSocket = Sersoc.accept();

                System.out.println("I'm Here for Listen you");
                System.out.println("Welcome " + clientSocket);
                output = new PrintWriter(clientSocket.getOutputStream(), true);
                output.println("Enter Data");
                    count++;
               Thread t = new ClientHandler(clientSocket);
               t.start();
                System.out.println(count);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
       // System.out.println("Enter Data For Send ");
       /* try {
            /*input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            if((inputLine=input.readLine())!=null)
            {
                //System.out.println("Server side: "+inputLine);
               // Thread t=new ClientHandler2(clientSocket,input);

            }
            while(true) {
                Thread t = new ClientHandler2(clientSocket);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


*/


