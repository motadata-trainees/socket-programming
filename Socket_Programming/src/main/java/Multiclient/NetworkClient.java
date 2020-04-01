package Multiclient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkClient extends Thread{

    public void run(){


        InetAddress address= null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Socket s1=null;
        String line=null;
        BufferedReader br=null;
        BufferedReader is=null;
        PrintWriter os=null;

        try {
            s1=new Socket(address, 4445); // You can use static final constant PORT_NUM
            br= new BufferedReader(new InputStreamReader(System.in));
            is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
            os= new PrintWriter(s1.getOutputStream());
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.print("IO Exception");
        }
        try {
            while (true) {
                System.out.println("Client Address : " + address);
                System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

                String response = null;
                line = br.readLine();
                if (line.compareTo("QUIT") != 0) {
                    os.println(line);
                    os.flush();
                    response = is.readLine();
                    System.out.println("Server Response : " + response);
                    // line=br.readLine();

                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Socket read Error");
        }
        finally{
            try {

                is.close();
                os.close();
                br.close();
                s1.close();
                System.out.println("Connection Closed");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}