package com.atguigu.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class FileChannelDemo1 {
    //FileChannel读取数据到buffer中
    public static void main(String[] args) throws Exception {
        Charset charset = Charset.forName("UTF-8");
        CharsetEncoder charsetEncoder = charset.newEncoder();
        CharsetDecoder charsetDecoder = charset.newDecoder();
        //创建FileChannel
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\admin\\Desktop\\2023年目标学习规划.txt","rw");
        // 获取 channel
        FileChannel channel = aFile.getChannel();
        // 创建Buffer 缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = charsetDecoder.decode(buffer);
        // 将数据通过管道读取到Buffer
        int read = channel.read(buffer);
        System.out.println("read" + read);
        // read为-1表示读取到文件末尾
        while (read != -1){
            // 从buffer 中利用管道读取出文件内容
            charBuffer.flip();
            while (buffer.hasRemaining()){
                System.out.println(charBuffer.get());
            }
            // 读取完成，清空buffer
            charBuffer.clear();
            read = channel.read(buffer);
        }
        // 读取结束，关闭channel
        aFile.close();
        System.out.println("结束了");
//        FileChannel channel = aFile.getChannel();
//
//        //创建Buffer
//        ByteBuffer buf = ByteBuffer.allocate(1024);
//
//        //读取数据到buffer中
//        int bytesRead = channel.read(buf);
//        while(bytesRead != -1) {
//            System.out.println("读取了："+bytesRead);
//            buf.flip();
//            while(buf.hasRemaining()) {
//                System.out.print((char)buf.get());
//            }
//            buf.clear();
//            bytesRead = channel.read(buf);
//        }
//        aFile.close();
//        System.out.println("结束了");
    }
}
