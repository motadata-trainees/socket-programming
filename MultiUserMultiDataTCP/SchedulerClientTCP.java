package MultiUserMultiDataTCP;

/**
 * Created by nilesh on 19/3/20.
 */
public class SchedulerClientTCP {
    public static void main(String[] args)
    {
      for(int i=0;i<5;i++)
        {
            TCPClientThread cl=new TCPClientThread();
            cl.start();
        }

    }
}
