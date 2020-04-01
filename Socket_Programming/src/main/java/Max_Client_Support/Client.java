package Max_Client_Support;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ravi on 16/3/20.
 */
public class Client extends Thread {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dataInputStream;
    final DataOutputStream dataOutputStream;
    final Socket s;


    // Constructor
    public Client(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dataInputStream = dis;
        this.dataOutputStream = dos;
    }

    @Override
    public void run()
    {
        String received = null;
        String toreturn = null;
        String str = "hello";
        while (true)
        {
            try {

                // Ask user what he wants
                dataOutputStream.writeUTF("What do you want?[Date | Time]..\n"+
                        "Type Exit to terminate connection.");

                // receive the answer from client
                received = dataInputStream.readUTF();

                if(received.equals("Exit"))
                {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }

                // creating Date object
                Date date = new Date();

                // write on output stream based on the
                // answer from the client
                switch(str) {

                    case "Date" :
                        toreturn = dateFormat.format(date);
                        dataOutputStream.writeUTF(toreturn);
                        break;

                    case "Time" :
                        toreturn = timeFormat.format(date);
                        dataOutputStream.writeUTF(toreturn);
                        break;

                    default:
                        dataOutputStream.writeUTF("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try
        {
            // closing resources
            this.dataInputStream.close();
            this.dataOutputStream.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
