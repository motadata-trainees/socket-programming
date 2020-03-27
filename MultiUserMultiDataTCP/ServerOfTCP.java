package MultiUserMultiDataTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;


public class ServerOfTCP {
    public static void main(String[] args) {
        PrintWriter out=null;
        ServerSocket ss = null;
        System.out.println("Server Start on "+java.time.LocalTime.now());
        try {
            ss = new ServerSocket(8686);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            String data="";
            int count=0;
            long diff=0;
            while (true)
            {

                Socket s = ss.accept();
               // s.setSoTimeout(3);
                System.out.println("Connected : "+s);
                BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                //long start=System.currentTimeMillis();
                while((data=input.readLine())!=null) {
                    System.out.println("Message From Client:"+data);
                    count++;
                    System.out.println(count);
                }

                //long end=System.currentTimeMillis();
               // diff=diff+(start-end);

            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }
