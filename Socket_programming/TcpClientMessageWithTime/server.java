package TcpClientMessageWithTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;

/**
 * Created by parth on 19/3/20.
 */
public class server {
    public static void main(String[] args) {
        PrintWriter out=null;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(2345);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            String data="";
            int count=0;
            long diff=0;
            while (diff<1)
            {
            while (true) {
                Socket s = ss.accept();
                System.out.println("conncted : " + s);
                BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                long start=System.currentTimeMillis();
                while ((data = input.readLine()) != null) {
                    System.out.println("from client:" + data);
                    count++;
                    System.out.println(count);
                }

                long end=System.currentTimeMillis();
                 diff=diff+(start-end);
                 if(diff>=1)
                 {
                     break;
                 }
            }
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }
