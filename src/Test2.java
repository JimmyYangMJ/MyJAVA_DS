import javax.swing.*;
import java.util.BitSet;
import java.util.concurrent.locks.StampedLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ymj
 * @Date： 2020/7/10 11:07
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "<script>CREATE TABLE IF NOT EXISTS `${database}` (\n" +
                "  `c_no` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '车牌号',\n" +
                "  `utc` int NOT NULL COMMENT '时间戳',\n" +
                "  `lon` decimal(10,6) NOT NULL COMMENT '经度',\n" +
                "  `lat` decimal(10,6) NOT NULL COMMENT '纬度',\n" +
                "  `spd` decimal(4,1) NOT NULL COMMENT '速度',\n" +
                "  `drc` int DEFAULT NULL COMMENT '方向',\n" +
                "  `time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '时间yyyy-MM-dd HH:mm:ss',\n" +
                "  `mil` decimal(10,3) NOT NULL DEFAULT '0.000',\n" +
                "  `edur` int NOT NULL DEFAULT '0',\n" +
                "  UNIQUE KEY `uk_cnoutc` (`c_no`,`utc`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;</script>";
//        System.out.println(s);
        byte b = 0b11;
        String redisAddress = "http://10.1.4.145:26379";
        // 匹配 ip
        Pattern pattern = Pattern.compile("(\\p{Digit}+?)\\.(\\p{Digit}+?)\\.(\\p{Digit}+?)\\.(\\p{Digit}+?):");
        Matcher matcher = pattern.matcher(redisAddress);
        String host = "127.0.0.1", port = "6379";
        while (matcher.find()) {
            host = matcher.group().trim();
            port = redisAddress.substring(7 + host.length() + 1);
            System.out.println(host + " " + port);
        }


    }
}
