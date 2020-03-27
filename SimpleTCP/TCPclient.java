package SimpleTCP;

/**
 * Created by nilesh on 17/3/20.
 */

import java.net.*;
import java.io.*;

public class TCPclient
{

    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;


    public TCPclient(String address, int port)
    {

        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected with Server");


            input = new DataInputStream(System.in);


            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }


        String line = "";


        while (!line.equals("Bye"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }


        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        TCPclient client = new TCPclient("localhost", 8888);
    }
}

