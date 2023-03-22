package com.atguigu.buffer;

import com.atguigu.dto.Album;
import com.atguigu.dto.Track;
import org.junit.jupiter.api.Test;

import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class BufferDemo1 {

    @Test
    public void test01() {
        // 找出长度大于1分钟的曲目名称
        List<Album> albums = new ArrayList<>(10);
        Album album1 = new Album("莫扎特","莫扎特交响乐");
        List<Track> tracks = new ArrayList<>();
        Track track1 = new Track("1", "莫扎特交响乐1",100);
        Track track2 = new Track("2","莫扎特交响乐2", 30);
        tracks.add(track1);
        tracks.add(track2);
        album1.setTrackList(tracks);
        albums.add(album1);

        Album album2 = new Album("s贝多芬","贝多芬交响乐");
        List<Track> tracks2 = new ArrayList<>();
        Track track3 = new Track("1", "贝多芬交响乐1",100);
        Track track4 = new Track("2","贝多芬交响乐2", 30);
        tracks2.add(track3);
        tracks2.add(track4);
        album2.setTrackList(tracks2);
        albums.add(album2);

        Album album3 = new Album("s郎朗","郎朗交响乐");
        List<Track> tracks3 = new ArrayList<>();
        Track track5 = new Track("1", "郎朗交响乐1",100);
        Track track6 = new Track("2","郎朗交响乐2", 30);
        tracks3.add(track5);
        tracks3.add(track6);
        album3.setTrackList(tracks3);
        albums.add(album3);

        Album album4 = new Album("s郎朗","郎朗交响乐");
        List<Track> tracks4 = new ArrayList<>();
        Track track7 = new Track("1", "郎朗交响乐1",100);
        Track track8 = new Track("2","郎朗交响乐2", 30);
        tracks3.add(track7);
        tracks3.add(track8);
        album3.setTrackList(tracks4);
        albums.add(album4);


        List<Album> albumList = albums.stream()
                .filter(item -> item.getName().startsWith("s"))
                .peek(item -> System.out.println("item = " + item))
                .collect(toList());
        System.out.println("albumList = " + albumList);


    }






    @Test
    public void buffer01() throws Exception {
        //FileChannel
        RandomAccessFile aFile = new RandomAccessFile("d:\\atguigu\\01.txt", "rw");
        FileChannel channel = aFile.getChannel();

        //创建buffer，大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //读
        int bytesRead = channel.read(buffer);

        while (bytesRead != -1) {
            //read模式
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            bytesRead = channel.read(buffer);
        }

        aFile.close();
    }


    @Test
    public void buffer02() throws Exception {

//        //创建buffer
//        IntBuffer buffer = IntBuffer.allocate(8);
//
//        //buffer放
//        for (int i = 0; i < buffer.capacity(); i++) {
//            int j = 2*(i+1);
//            buffer.put(j);
//        }
//
//        //重置缓冲区
//        buffer.flip();
//
//        //获取
//        while(buffer.hasRemaining()) {
//            int value = buffer.get();
//            System.out.println(value+" ");
//        }

        // 1、获取Selector选择器
        Selector selector = Selector.open();

        // 2、获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 3.设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 4、绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9999));

        // 5、将通道注册到选择器上,并制定监听事件为：“接收”事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    }

}
