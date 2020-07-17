package com.net.nio.nioFile;

/**
 * Title: Client.java
 * Description:
 * @author：wh
 * @date 2019年7月9日
 * @version 1.0
 * Company: itiis
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;



/**
 *@class_name：Client
 *@comments:nio传输文件客户端（接收）
 *@param:
 *@return:
 *@author:wh
 *@createtime:2019年7月9日
 */
public class Client {
    //管道管理器
    private Selector selector;

    public Client init(String serverIp, int port) throws IOException, InterruptedException{
        //获取socket通道
        SocketChannel channel = SocketChannel.open();

        channel.configureBlocking(false);
        //获得通道管理器
        selector=Selector.open();

        //客户端连接服务器，需要调用channel.finishConnect();才能实际完成连接。
        boolean connectResult = channel.connect(new InetSocketAddress(serverIp, port));

        //为该通道注册SelectionKey.OP_CONNECT事件
        channel.register(selector, SelectionKey.OP_CONNECT);
        return this;
    }

    public void listen() throws IOException{
        System.out.println("客户端启动");
        //轮询访问selector
        while(true){
            //选择注册过的io操作的事件(第一次为SelectionKey.OP_CONNECT)
            selector.select();
            Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
            while(ite.hasNext()){
                SelectionKey key = ite.next();
                //删除已选的key，防止重复处理
                ite.remove();
                if(key.isConnectable()){
                    SocketChannel channel=(SocketChannel)key.channel();
                    //如果正在连接，则完成连接
                    if(channel.isConnectionPending()){
                        channel.finishConnect();
                    }
                    channel.configureBlocking(false);
                    //向服务器发送消息
                    channel.write(ByteBuffer.wrap(new String("send message to server.").getBytes()));
                    //连接成功后，注册接收服务器消息的事件
                    channel.register(selector, SelectionKey.OP_READ);//订阅读取事件
                    System.out.println("客户端连接成功");
                }else if(key.isReadable()){ //有可读数据事件。
                    SocketChannel channel = (SocketChannel)key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(4);

                    File file = new File("D:\\test3.txt");
                    if(!file.exists()) file.createNewFile();
                    FileOutputStream fe =new FileOutputStream(file,true);//可追加写
                    FileChannel outFileChannel = fe.getChannel();
                    while(channel.read(byteBuffer) > 0){ //分多次读取
                        System.out.println(new String(byteBuffer.array(), "UTF-8"));
                        byteBuffer.flip();
                        outFileChannel.write(byteBuffer);//byteBuffer转换为数据写到FileChannel
                        fe.flush();
                        byteBuffer.clear();
                    }
                    outFileChannel.close();

                    fe.close();
                    System.out.println("读取结束");
                    channel.close();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Client().init("127.0.0.1", 9981).listen();
    }

}
