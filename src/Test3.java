import java.lang.reflect.Field;
/**
 * integer  缓存问题
 cache[0] == -128，
 cache[1] == -127，
 cache[2] == -126，
 ……
 * @author ymj
 * @Date： 2020/7/10 11:07
 */
public class Test3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

//        Class cache = Integer.class.getDeclaredClasses()[0]; //1
//        Field myCache = cache.getDeclaredField("cache"); //2
//        myCache.setAccessible(true);//3
//        Integer[] newCache = (Integer[]) myCache.get(cache); //4
//
//        System.out.println(newCache[132] + " " + newCache[133]);
//        newCache[132] = newCache[133]; //5
//        System.out.println(newCache[132] + " " + newCache[133]);
//        int a = 2;
//        int b = 4;
//        System.out.printf("%d + %d = %d", a, a, b); //


    }
}
