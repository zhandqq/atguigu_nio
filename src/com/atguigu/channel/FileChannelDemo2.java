package com.atguigu.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//FileChanne写操作
public class FileChannelDemo2 {

    public static void main(String[] args) throws Exception {
        // 打开FileChannel
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\admin\\Desktop\\111.txt","rw");
        // 获取Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 定义写入内容
        String str = "Hello";
        //  向buffer中写入内容
        buffer.put(str.getBytes());
        // 读写转换
        buffer.flip();
        // 获取 channel
        FileChannel channel = randomAccessFile.getChannel();
        while (buffer.hasRemaining()){
            channel.write(buffer);
            channel.truncate(4);
        }
        channel.close();
//        RandomAccessFile aFile = new RandomAccessFile("d:\\atguigu\\001.txt","rw");
//        FileChannel channel = aFile.getChannel();
//
//        //创建buffer对象
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//
//        String newData = "data atguigu";
//        buffer.clear();
//
//        //写入内容
//        buffer.put(newData.getBytes());
//
//        buffer.flip();
//
//        //FileChannel完成最终实现
//        while (buffer.hasRemaining()) {
//            channel.write(buffer);
//        }
//
//        //关闭
//        channel.close();
    }
}
