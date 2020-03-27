package MultiUserMultiDataUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import static TimeSliceCon.ClientHandler2.count;

/**
 * Created by nilesh on 18/3/20.
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(8888);
        byte[] receive = new byte[65507];
        int count=0;
        DatagramPacket DpReceive = null;
        System.out.println("Server Start on "+java.time.LocalTime.now());

        while (true) {

            System.out.println("Here For Listen You");
            DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);
          //  System.out.println("Packet Recieved Count  " + count);

            // String s=new String(receive);
            // System.out.println(s+s.length());

            System.out.println("Client Message:- " + data(receive)+" Message Length " + data(receive).length());
            count++;
            System.out.println(count);
            if (data(receive).toString().equals("bye")) {
                System.out.println("Client sent bye.....EXITING");
                break;
            }
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
