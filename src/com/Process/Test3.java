package com.Process;

import java.io.*;

/**
 * @author ymj
 * @Date： 2020/8/3 15:35
 * @description: 获取操作系统相关信息
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        String OS = System.getProperty("os.name").toLowerCase();
        System.out.println(OS);
        String[] cmd = new String[] { "cmd", "/c",
                "tasklist|find /i \"redis-server.exe\""
        };// cmd[2]是要执行的dos命令
        Process process = Runtime.getRuntime().exec(cmd);
        // 记录dos命令的返回信息
        StringBuffer resStr = new StringBuffer();
        // 获取返回信息的流
        InputStream in = process.getInputStream();
        Reader reader = new InputStreamReader(in, "GBK");
        BufferedReader bReader = new BufferedReader(reader);
        for (String res = ""; (res = bReader.readLine()) != null;) {
            resStr.append(res + "\n");
        }
        process.getOutputStream().close();
        System.out.println(resStr.toString().trim());
        System.out.println(resStr.toString().trim().length());

    }
}
