package SingleUDP;

import java.io.IOException;
import java.net.*;

/**
 * Created by nilesh on 18/3/20.
 */
public class NoOfClientUDP {
    public static void main(String[] args) {
        try  {
            DatagramSocket Server = new DatagramSocket();
            //Socket [] cls=new Socket[6553];
            InetAddress address= null;
            byte buf[] = null;
            //InetAddress ip = InetAddress.getLocalHost();
            DatagramPacket clientss[]=new DatagramPacket[63535];

            try {
                //address = InetAddress.getLocalHost();
                address=InetAddress.getByName("localhost");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
           // Socket s=new Socket("localhost",9848);
            for (int i = 0; i < clientss.length; i++) {
               // clients[i] = new DatagramSocket(8899,address);
                String inp = "Hi";

                buf = inp.getBytes();
                clientss[i] = new DatagramPacket(buf, buf.length, address, 8899);

                Server.send(clientss[i]);

               // clients[i].bind();
            //    System.out.printf("Client %2d: " + clients[i] + "%n", i);
                System.out.println("Clients "+i+" :"+clientss[i]);
               // Thread.sleep(100);
               // server.accept();
                //clientss[i].close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
