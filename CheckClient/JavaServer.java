package CheckClient;

import java.net.ServerSocket;

/**
 * Created by nilesh on 13/3/20.
 */
public class JavaServer {
    public static void main(String[] args) {

                try {
                    ServerSocket ss = new ServerSocket(8898);
                   // ss.setReceiveBufferSize(900000);
                    boolean listening=true;

                    while(listening){
                        Thread t=new ServerThread(ss.accept());
                        t.start();
                        //t.join();
                       // Thread.sleep(10);
                    }
                    ss.close();
                } catch (Exception e) {
                    System.out.println(e);
                }


        System.out.println("the end of main method");
    }
}

