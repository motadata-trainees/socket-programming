package ThreadServer;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ravi on 13/3/20.
 */
public class UppercsaeServer {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket listener = new ServerSocket(11111);
            System.out.println("The UpperCase server is running...");
            ExecutorService pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Capitalizer(listener.accept()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
