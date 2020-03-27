package SimpleTCP;

/**
 * Created by nilesh on 17/3/20.
 */

import java.net.*;
import java.io.*;

public class TCPserver
{

    private Socket		 socket = null;
    private ServerSocket server = null;
   private DataInputStream in	 = null;
    //private PrintWriter out=null;

    public TCPserver(int port)
    {

        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");


           in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
          //  out = new PrintWriter(String.valueOf(socket.getInputStream()));
            String line = "";


            while (!line.equals("Bye"))
            {
                try
                {
                    line = in.readUTF();
                  //  out.write(line);
                    System.out.println(line);
                    System.out.println(line.length());

                }
                catch(Exception i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");


            socket.close();
            in.close();
           // out.close();
           // out.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        TCPserver server = new TCPserver(8888);
    }
}

