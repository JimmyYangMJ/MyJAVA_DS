import java.util.Deque;
import java.util.HashSet;

/**
 * @author ymj
 * @Date£º 2019/12/14 23:44
 */
public class Main {

    public static void main(String[] args) {
        String a = "qwe_123kasd..a,// 234asADFfgZ";
        System.out.println(a.replaceAll("[^a-z^A-Z.////{2}]", ""));
    }

}
