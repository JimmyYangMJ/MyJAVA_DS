
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner cin = new Scanner(System.in);

    public static void main(String args[]) {
        Random r = new Random();
        r.getClass();
        String a;
        System.out.println(Double.compare(5.3, 2.3));
        byte[] bytes=new byte[1024];
        FileInputStream fis = null;
        try {
            fis.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}