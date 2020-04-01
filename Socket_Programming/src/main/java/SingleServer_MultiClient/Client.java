package SingleServer_MultiClient;

/**
 * Created by ravi on 13/3/20.
 */
public class Client {
    public static void main(String[] args) {
        for(int i=0;i<100000;i++) {
            ClientRunner clientRunner = new ClientRunner(Integer.toString(i));
            clientRunner.start();
        }

    }
}
