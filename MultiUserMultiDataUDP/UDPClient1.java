package MultiUserMultiDataUDP;

import java.io.IOException;
import java.net.*;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Created by nilesh on 19/3/20.
 */
public class UDPClient1 extends Thread {
    public  void run()
    {
        //Scanner sc = new Scanner(System.in);
        System.out.println(Thread.currentThread().getName());
        int inner_count=1;
        while(inner_count<10) {

            int count = 500;
            DatagramSocket ds = null;
            try {
                ds = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }

            InetAddress ip = null;
            try {
                ip = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            byte buf[] = null;
            String message = "How Are you Bro";
            buf = message.getBytes();
            DatagramPacket DatapacketSend=null;
            DatapacketSend   = new DatagramPacket(buf, buf.length, ip, 8888);
            inner_count++;
            while (count >= 1) {

                try {
                    ds.send(DatapacketSend);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                count--;

            }
            System.out.println(Thread.currentThread().getName()+"   Send Time "+inner_count+"  Total Sended Data "+(inner_count*500));
            System.out.println(LocalTime.now());
           try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
