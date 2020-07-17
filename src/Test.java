

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

/**
 * @Mod
 */
public class Test {
     private Logger logger=Logger.getLogger(this.getClass());

    public static void main(String[] args) throws Exception {

        System.out.printf("%s\n", getMacStr());
    }

    public static String getMacStr() throws Exception{
        InetAddress ia = InetAddress.getLocalHost();
        return getLocalMac(ia);
    }

    private static String getLocalMac(InetAddress ia) throws SocketException {
        //获取网卡，获取地址
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        System.out.println();
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            if(i!=0) {
                sb.append("-");
            }
            //字节转换为整数
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }
        return sb.toString().toUpperCase();
    }

}