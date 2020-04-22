package udpmulti;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UnSyncChatClient extends Thread {

    public static void main(String[] args)
    {
        try {
            DatagramSocket cs = new DatagramSocket(5334);
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Running UnSyncChatClient.java");
            System.out.println("Client is Up....");
            Thread csend;
            csend = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Scanner sc = new Scanner(System.in);
                        while (true) {
                            synchronized (this) {
                                byte[] sd = new byte[1000];
                                sd = sc.nextLine().getBytes();
                                DatagramPacket sp = new DatagramPacket(sd, sd.length, ip, 1234);
                                cs.send(sp);
                                String msg = new String(sd);
                                System.out.println("Client says: " + msg);
                                if (msg.equals("bye"))
                                {
                                    System.out.println("client " + "exiting... ");
                                    break;
                                }
                                System.out.println("Waiting for " + "server response...");
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Exception occured");
                    }
                }
            });

            Thread creceive;
            creceive = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            synchronized (this) {
                                byte[] rd = new byte[1000];
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
                    } catch (IOException e) {
                        System.out.println("Exception occured");
                    }
                }
            });

            //for (int i=0;i<10000;i++) {
                csend.start();
                creceive.start();
           // }


            csend.join();
            creceive.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
} 