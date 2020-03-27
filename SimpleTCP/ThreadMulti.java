package SimpleTCP;

/**
 * Created by nilesh on 17/3/20.
 */
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadMulti{
    public static void main(String[] args) {
        final AtomicBoolean shouldRun = new AtomicBoolean(true);
        try  {
            final ServerSocket server = new ServerSocket(2123);
            Thread serverThread = new Thread(){
                public void run() {
                    try {
                        while(shouldRun.get()) {
                            Socket s = server.accept();
                            s.close();
                            Thread.sleep(1);
                        }
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            serverThread.start();
            Socket[] clients = new Socket[65535];
            for (int i = 0; i < clients.length; i++) {
                clients[i] = new Socket("localhost", 2123);
             //   System.out.printf("Client %2d: " + clients[i] + "%n", i);
                System.out.println("Client "+i+" "+clients[i]);
                clients[i].close();
            }
            shouldRun.set(false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shouldRun.set(false);
        }

    }
}
