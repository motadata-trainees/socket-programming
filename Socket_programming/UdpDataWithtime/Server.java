package UdpDataWithtime;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by parth on 18/3/20.
 */
public class Server {
    public static int i=0;
    public static void main(String[] args)
    {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        try {
            DatagramSocket ds = new DatagramSocket(7777);
            byte[] receive = new byte[100000];
            DatagramPacket DpReceive = null;
            DpReceive = new DatagramPacket(receive, receive.length);
            if (ds != null) {
                long diff = 0;
                while (true) {

                    //System.out.println(start);

                    ds.receive(DpReceive);
                    long start = System.currentTimeMillis();
                    System.out.println("Client:- " + data(receive) + " " + i);
                    i++;
                    long end = System.currentTimeMillis();
                    //System.out.println(end);
                    diff = diff+(end - start);
                    System.out.println(diff);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
/*class main
{
    public static void main(String[] args) {
        Server s=new Server();
        s.start();
    }
}*/

