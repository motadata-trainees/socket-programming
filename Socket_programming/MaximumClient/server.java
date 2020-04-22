package MaximumClient;

import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        //ServerSocket serverSocket=new ServerSocket(3333);
        Socket[] socket=new Socket[65535];
        for (int i=0;i<socket.length;i++)
        {
            socket[i]=new Socket("localhost",3333);
            //socket[i]=serverSocket.accept();
            System.out.println("clients : "+i+" "+socket[i]);
        }

    }
}
