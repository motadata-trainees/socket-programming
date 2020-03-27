package SingleUDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPserver
{
    public static void main(String[] args) throws IOException
    {
        int count=0;
        DatagramSocket ds = new DatagramSocket(8899);
        byte[] receive = new byte[100000];

        DatagramPacket DpReceive = null;
        System.out.println(java.time.LocalTime.now());
        while (true)
        {
            System.out.println(java.time.LocalTime.now());
            count++;
            System.out.println("Welcome Client ");
            DpReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DpReceive);
            System.out.println("Packet Recieved Count  "+count);
           // String s=new String(receive);
           // System.out.println(s+s.length());

            System.out.println("Client:- "+data(receive) + data(receive).length());


            if (data(receive).toString().equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
                break;
            }


           // receive = new byte[65535];
        }
        System.out.println(java.time.LocalTime.now());
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
