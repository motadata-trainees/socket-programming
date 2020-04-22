package UdpDataWithtime;

import multiclient.Client;

/**
 * Created by parth on 19/3/20.
 */
public class schedular {

    public static void main(String[] args) {

        for (int i=0;i<5;i++)
        {
            client c = new client();
            c.start();
        }
    }
}
