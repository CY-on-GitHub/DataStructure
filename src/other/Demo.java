package other;

/**
 * Created by asus on 2020/3/6.
 */
public class Demo {

    public static void main(String args[]){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                new VolatileExample().writer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                new VolatileExample().reader();
            }
        });
        thread1.start();
        thread2.start();
    }

}
