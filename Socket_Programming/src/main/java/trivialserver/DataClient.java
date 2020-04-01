package trivialserver;

import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ravi on 13/3/20.
 */
public class DataClient {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",8888);
            Scanner in = new Scanner(socket.getInputStream());
            System.out.println("Server Response"+ in.nextLine());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
