package MultiUserMultiDataUDP;

/**
 * Created by nilesh on 19/3/20.
 */
public class SchedulerClient
{
    public static void main(String[] args)
    {
            for (int i = 0; i < 5; i++) {
                UDPClient1 client = new UDPClient1();
                client.start();
               // System.out.println(Thread.currentThread().ge);
            }
    }
}
