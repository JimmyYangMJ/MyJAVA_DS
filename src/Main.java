import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author ymj
 * @Date： 2019/12/14 23:44
 */
public class Main {

    public static void main(String[] args) {
        LocalDateTime rightNow = LocalDateTime.now();

        System.out.println("当前：" + rightNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss") ));


    }

}
