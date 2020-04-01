package Multiclient;

/**
 * Created by parth on 13/3/20.
 */
public class schedular {
    public static void main(String[] args) {
        for (int i=0;i<10000;i++)
        {
            System.out.println("Client number is: "+i);
            Thread t=new NetworkClient();
            t.start();
        }
    }
}
