package singleTcpClientServer;

import com.sun.xml.internal.ws.api.server.ThreadLocalContainerResolver;

import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;

public class MyServer {
    public static void main(String[] args){
        BufferedReader input=null;
        PrintWriter out=null;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }

                try {
                    Socket s = ss.accept();
                    out = new PrintWriter(s.getOutputStream(), true);
                    input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String sk = "";

                  while (!sk.equals("over"))
                    {
                        sk=input.readLine();
                        out.println(sk);
                        System.out.println("message= " + sk.length());
                    }
                    input.close();
                    out.close();

                } catch (Exception e) {
                    System.out.println(e);
                }

    }
}
