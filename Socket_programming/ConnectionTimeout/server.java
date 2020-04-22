package ConnectionTimeout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by parth on 20/3/20.
 */
public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9779);
            Thread.sleep(10000);

            while (true) {
                Socket st = ss.accept();
                BufferedReader br=new BufferedReader(new InputStreamReader(st.getInputStream()));
                PrintWriter out=new PrintWriter(st.getOutputStream(),true);
                if(st.isConnected())
                {
                    System.out.println("client "+ st);
                    out.println("client is connected");

                }
            }


        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
