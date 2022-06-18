package com.lagou.server;

import com.lagou.demo.IMyServer;
import com.lagou.demo.impl.IMyServerImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author ADMIN
 * @date 2022/6/16 22:14
 */
public class RMIServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        //创建一个远程对象,同事会创建stub对象,以及skeleton对象
        IMyServer iMyServer = new IMyServerImpl();
        //启动注册服务 创建了远程对象注册表Registry的实例,并指定端口为8888
        Registry registry = LocateRegistry.createRegistry(8888);
        //镇真正的注册:绑定url的标准模式:  rmi//host
        Naming.bind("//127.0.0.1:8888/zm",iMyServer);
    }
}
