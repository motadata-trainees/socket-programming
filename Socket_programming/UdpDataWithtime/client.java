package UdpDataWithtime;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by parth on 18/3/20.
 */
public class client extends Thread{
    public void run() {
        try {

            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = null;
            String inp = "hello world "+Thread.currentThread().getName();
            byte buf[] = inp.getBytes();
            InetAddress ip = InetAddress.getLocalHost();
            dp = new DatagramPacket(buf, buf.length, ip, 7777);
            String s = "";

            int count = 500;
            while (count > 0) {
                ds.send(dp);
                count--;
                s = s + inp;
            }
         //  System.out.println(s);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
