package TcpClientAccess;

import java.net.*;
import java.io.*;

public class BootManager {
    public static void main(String args[]){
        for(int i = 0;i<1000;i++){
            ClientHandler client = new ClientHandler(i);
            client.start();
        }

    }

}
