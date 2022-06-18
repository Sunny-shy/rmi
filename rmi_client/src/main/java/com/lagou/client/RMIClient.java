package com.lagou.client;

import com.lagou.demo.IMyServer;
import com.lagou.pojo.User;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author ADMIN
 * @date 2022/6/16 23:22
 */
public class RMIClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        //在注册表中查找zm注册的对象
        IMyServer lookup = (IMyServer) Naming.lookup("//127.0.0.1:8888/zm");
        User user = new User();
        user.setAge(11);
        user.setName("xiaoxiao");
        System.out.println(lookup.sayHello(user));



    }
}
