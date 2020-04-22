package ConnectionTimeout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by parth on 20/3/20.
 */
public class client {
    public static void main(String[] args) {
        try {

            SocketAddress sockaddr = new InetSocketAddress(InetAddress.getByName("localhost"),9779);
            Socket socket;
            socket = new Socket("localhost",9779);
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int timer=0;
            int POLL_DELAY=3000;
            int delay=13000;
            while (true)
            {
                // Check to see if a connection is established
                if (socket.isConnected())
                {
                    // Yes ...  assign to sock variable, and break out of loop
                    System.out.println("from server : "+br.readLine());
                    break;
                }
                else
                {
                    try
                    {
                        // Sleep for a short period of time
                        Thread.sleep ( POLL_DELAY );
                    }
                    catch (InterruptedException ie) {}
                    // Increment timer
                    timer += POLL_DELAY;
                    // Check to see if time limit exceeded
                    if (timer > delay)
                    {
                        // Can't connect to server
                        throw new InterruptedIOException
                                ("Could not connect for " + delay +
                                        " milliseconds");
                    }
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
