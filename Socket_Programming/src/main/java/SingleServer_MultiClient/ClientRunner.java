package SingleServer_MultiClient;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ravi on 13/3/20.
 */
public class ClientRunner extends Thread {
    private String name;
    ClientRunner(String name)
    {
        this.name= name;
    }
    public void run() {
        try{
            Socket socket = new Socket("localhost",11111);
            System.out.println("Client no : "+name);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println("Server response: "+in.nextLine());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
