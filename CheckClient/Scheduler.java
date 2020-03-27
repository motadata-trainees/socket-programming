
package CheckClient;
public class Scheduler {
    public static void main(String[] args) {
        int count=0;
        for(int i=0;i<100000;i++)
        {
            count++;
            Client ch=new Client();
            ch.start();
            System.out.println(count);
            System.out.println(Thread.currentThread().getName());
        }
    }
}
