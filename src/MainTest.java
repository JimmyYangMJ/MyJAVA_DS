
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.locks.LockSupport;


/**
 * 118. 杨辉三角 Pascal's Triangle
 * @author ymj
 * @Date： 2020/1/19 18:22
 */
public class MainTest {

    private static  int radius = 1;
    private int count =2;

     static Integer a = 10;

    volatile static Object object = new Object();

    class Inner {
        public void visit() {
            System.out.println("visit outer static  variable:" + radius);
            System.out.println("visit outer   variable:" + count);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MainTest in = new MainTest();
        Inner inner = in.new Inner();
        a = 10;

        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);

        Thread a = new Thread(new test1());
        a.start();

        a = new Thread(new test2());
        a.start();

        a = new Thread(new test());
        a.start();



    }

}

class test1 implements Runnable{

    @Override
    public void run() {
        try {
            MainTest.object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("777777");


    }
}
class test2 implements Runnable{

    @Override
    public void run() {
            try {
                MainTest.object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("666666");

    }
}
class test implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            MainTest.object.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5555555");


    }
}