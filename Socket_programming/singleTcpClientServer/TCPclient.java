package singleTcpClientServer;

import java.io.*;
import java.net.*;
public class TCPclient
{
    private Socket socket = null;
    private DataInputStream input = null;
    private PrintWriter out    = null;
    public TCPclient(String address, int port)
    {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            out = new PrintWriter(socket.getOutputStream());
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
        while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                out.write(line);
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
        TCPclient client = new TCPclient("10.20.40.24", 8899);
    }
}
