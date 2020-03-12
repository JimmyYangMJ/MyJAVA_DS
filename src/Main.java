import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ymj
 * @Date： 2019/12/14 23:44
 */
public class Main {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            
            list.add(list.get(i-1) + list.get(i));
        }

        return list;
    }

    public static void main(String[] args) {

    }

}
