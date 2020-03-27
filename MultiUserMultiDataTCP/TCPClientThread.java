package MultiUserMultiDataTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;


public class TCPClientThread extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName());
        int inner_count=1;
        while (true) {
            try {
                int count = 500;
                Socket s = new Socket("localhost", 8686);
                System.out.println("client connected");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                String line = "Hello I am Nilesh";
                inner_count++;
                while (count >= 1) {
                    //System.out.println(line);
                    out.println(line);
                    count--;
                }
                br.close();
                out.close();
                s.close();
                System.out.println(Thread.currentThread().getName()+"   Send Time "+inner_count+"  Total Sended Data "+(inner_count*500));
                System.out.println(LocalTime.now());
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
