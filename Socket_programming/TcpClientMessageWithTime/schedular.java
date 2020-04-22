package TcpClientMessageWithTime;

/**
 * Created by parth on 19/3/20.
 */
public class schedular {
    public static void main(String[] args) {
        for(int i=0;i<1500;i++)
        {
            client cl=new client();
            cl.start();
        }
    }
}
