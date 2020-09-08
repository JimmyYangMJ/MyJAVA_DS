import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
public class Test4 {

    public static void main(String[] args) throws IOException {
        //将遍历得到的经纬度存放在list集合中
        Collection<String> listJd1 = new ArrayList<>();
        Collection<String> listJd2 = new ArrayList<>();
        //将需要处理得到的经纬度存放在list集合中
        Collection<String> listWd1 = new ArrayList<>();
        Collection<String> listWd2 = new ArrayList<>();

        System.out.println("读excel文件结果如下：");
        String jwd = null;
        // InputStreamReader isr1 = new InputStreamReader(new FileInputStream("C://Users//ASUS//Desktop//共享单车框位导入//浦东新区经度表.csv"), "UTF-8"); //或GB2312,GB18030
        // isr2 = new InputStreamReader(new FileInputStream("C://Users//ASUS//Desktop//共享单车框位导入//浦东新区纬度表.csv"), "UTF-8"); //或GB2312,GB18030
        //BufferedReader bufferedReader1 = new BufferedReader(isr1);
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("D://单车处理//经度表.csv"));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("D://单车处理//纬度表.csv"));

        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        //读取文件操作：
        while ((s1 = bufferedReader1.readLine()) != null) {
            if (s1.equals(""))
                continue;
            else
                listJd1.add(s1);
        }
        while ((s2 = bufferedReader2.readLine()) != null) {
            if (s2.equals(""))
                continue;
            else
                listWd1.add(s2);
        }
        //打印输出excel表格所有的经纬度看看是否遍历完整：
/*        for (int i = 0; i < listJd1.size(); i++) {
           System.out.println(((ArrayList<String>) listJd1).get(i));
        }*/
        for (int i = 0; i < listJd1.size(); i=i+4) {//
            int  j1=i;
            int  j2=i+1;
            int  j3=i+2;
            int  j4=i+3;
            if(i%4==0)
            {
                System.out.println(
                        ((ArrayList<String>) listJd1).get(j1)+" "+((ArrayList<String>) listWd1).get(j1)+","
                                +((ArrayList<String>) listJd1).get(j2)+" "+((ArrayList<String>) listWd1).get(j2)+","
                                +((ArrayList<String>) listJd1).get(j3)+" "+((ArrayList<String>) listWd1).get(j3)+","
                                +((ArrayList<String>) listJd1).get(j4)+" "+((ArrayList<String>) listWd1).get(j4)+","
                                +((ArrayList<String>) listJd1).get(j1)+" "+((ArrayList<String>) listWd1).get(j1)
                );
            }
        }
    }
}