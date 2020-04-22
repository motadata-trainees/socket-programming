package TcpClientMessageWithTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by parth on 19/3/20.
 */
public class client extends Thread {
    public void run() {
        try {
            Socket s = new Socket("localhost", 2345);
            System.out.println("client connected");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(s.getOutputStream(),true);
            String line = "hello";
            int count=500;
            while (count>0)
            {
                //System.out.println(line);
                out.println(line);
                count--;
            }
            br.close();
            out.close();
            s.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
