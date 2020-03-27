package MultipleUDP;

/**
 * Created by nilesh on 16/3/20.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultiUDPClient {

    public static void main(String args[]) throws IOException, InterruptedException
    {

        DatagramSocket cs = new DatagramSocket(3656);
        InetAddress ip = InetAddress.getLocalHost();

        System.out.println("Running Client...");

        System.out.println("Client is Up....");

        Thread csend,creceive;

        csend = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    Scanner sc = new Scanner(System.in);
                    while (true) {
                        synchronized (this)
                        {
                            System.out.println(Thread.currentThread().getName());

                            byte[] sd = new byte[65535];
                            sd = sc.nextLine().getBytes();

                            DatagramPacket sp = new DatagramPacket(sd, sd.length, ip, 9848);
                            cs.send(sp);

                            String msg = new String(sd);
                            System.out.println("Client says: " + msg.length());

                            if (msg.equals("bye"))
                            {
                                System.out.println("client " + "exiting... ");
                                break;
                            }
                            System.out.println("Waiting for " + "server response...");
                        }
                    }
                }
                catch (IOException e) {
                    System.out.println("Exception occured");
                }
            }
        });

       // Thread creceive;
        creceive = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {

                    while (true) {
                        synchronized (this)
                        {
                            System.out.println(Thread.currentThread().getName());

                            byte[] rd = new byte[65535];

                            DatagramPacket sp1 = new DatagramPacket(rd, rd.length);
                            cs.receive(sp1);

                            String msg = (new String(rd)).trim();
                            System.out.println("Server: " + msg);


                            if (msg.equals("bye"))
                            {
                                System.out.println("Server" + " Stopped....");
                                break;
                            }
                        }
                    }
                }
                catch (IOException e) {
                    System.out.println("Exception occured");
                }
            }
        });

        csend.start();
        creceive.start();

        csend.join();
        creceive.join();
    }
}

