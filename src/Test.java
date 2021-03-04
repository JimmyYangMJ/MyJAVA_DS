

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Assert;

import javax.imageio.ImageIO;

/**
 * @Mod
 */
public class Test {
     private Logger logger=Logger.getLogger(this.getClass());

    public static void main(String[] args) throws Exception {

        String name=java.net.URLEncoder.encode("测试", "UTF-8");
        System.out.println(name);
        System.out.println(java.net.URLDecoder.decode(name, "ISO-8859-1"));
//        编码后的是%E6%B5%8B%E8%AF%95；
//        而用ISO-8859-1解码后的是???è?；
        System.out.println(java.net.URLDecoder.decode(name, "UTF-8"));
        //System.out.printf("%s\n", getMacStr());
    }

    public static String getMacStr() throws Exception{
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println(ia.getHostAddress());
        return getLocalMac(ia);
    }

    /**
     * @param ia
     * @return
     * @throws SocketException
     */
    private static String getLocalMac(InetAddress ia) throws SocketException {
        //获取网卡，获取地址
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        System.out.println();
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            if(i!=0) {
                sb.append("-");
            }
            // 字节转换为整数
            int temp = mac[i] & 0xff;
            String str = Integer.toHexString(temp);
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }
        return sb.toString().toUpperCase();
    }

    /**
     * @param path
     */
    public static void createFongImg(String path){
        String base = "44";

        try{
            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage newImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
            Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
            graphics2D.setFont(new Font("宋体",Font.BOLD,12));
            int index = 0;
            for(int y = 0; y < image.getHeight(); y += 12){
                for (int x = 0; x < image.getWidth(); x += 12){
                    int pxcolor = image.getRGB(x,y);
                    int r = (pxcolor & 0xff0000) >> 16,
                            g = (pxcolor & 0xff00) >> 8,
                            b = pxcolor & 0xff;
                    graphics2D.setColor(new Color(r, g, b));
                    graphics2D.drawString(String.valueOf(base.charAt(index % base.length())), x, y);
                    index++;
                }
            }
            ImageIO.write(newImage, "JPG", new FileOutputStream("D:\\temp.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}