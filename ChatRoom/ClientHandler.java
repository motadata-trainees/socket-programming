package ChatRoom;
import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by nilesh on 12/3/20.
 */
public class ClientHandler extends Thread {
    final Socket ClientSocket;
    BufferedReader input;                                            //final BufferedReader bufferedReader;   //DataOutput dos=null;
  //  String input1;
   /* public ClientHandler2(Socket clsoc, BufferedReader br)
    {
        this.ClientSocket=clsoc;
        this.bufferedReader=br;
    }*/

    public ClientHandler(Socket clsoc)
    {
        this.ClientSocket=clsoc;           // this.bufferedReader=null;
    }
    public void run()
    {
        String received;
       // int bufferSize = 64 * 1024;
        try
        {// received= bufferedReader.readLine();

               input=new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
               //Scanner sc=new Scanner(ClientSocket.getInputStream());
               //input1= sc.nextLine();
            System.out.println(Thread.currentThread().getName());

            while ((received=input.readLine())!=null) {
                System.out.println(ClientSocket.getInetAddress()+" Says: "+received);
                System.out.println(ClientSocket.getInetAddress()+" Says: "+" BufferSize: "+received.length());
               // System.out.println(ClientSocket.getInetAddress()+" Says: "+input1.length()+" BufferSize: ");

                if (received.equals("Bye")) {
                    System.out.println("Connection Close of "+ClientSocket.getInetAddress());
                    break;

                }
            }

                                                              /*  while (true) {
                                                                    System.out.println("Server: "+received);
                                                                    if (received.equals("Bye")) {
                                                                        System.out.println("Connection Close");
                                                                        break;

                                                                    }
                                                                }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                 input.close();
                ClientSocket.close();
               // Sersoc.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }







    }
}
