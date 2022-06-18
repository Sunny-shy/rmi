package com.lagou.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author ADMIN
 * @date 2022/6/17 0:25
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        //创建NioEventLoopGroup的两个实例对象
        //线程池  线程数默认为cpu*2
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
//服务启动辅助类  装配一些组件
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        ServerBootstrap group = serverBootstrap.group(bossGroup, workerGroup)
                //指定服务器端监听套接字通道 NioServerSocketChannel
                .channel(NioServerSocketChannel.class)
                //业务职责链 childHandle
                //ChannelInitializer 初始化channel的channelpipeline
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) {
                        ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        //将一个一个的channelhandler添加到责任链上 在请求进来或者响应的时候 都会经过链上channel 进行处理
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext,String msg) {
                                System.out.println(msg);

                            }
                        });
                    }
                });
        //sync 用于阻塞当前的thread,一直到端口绑定操作完成
        ChannelFuture sync = serverBootstrap.bind(8000).sync();
        System.out.println("tcp server start success..");
        //会阻塞等待直到服务器的channel关闭
        sync.channel().closeFuture().sync();

    }
}
