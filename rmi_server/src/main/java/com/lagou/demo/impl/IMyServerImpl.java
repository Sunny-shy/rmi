package com.lagou.demo.impl;

import com.lagou.demo.IMyServer;
import com.lagou.pojo.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author ADMIN
 * @date 2022/6/16 22:11
 */
public class IMyServerImpl extends UnicastRemoteObject implements IMyServer {
    public IMyServerImpl() throws RemoteException {
    }

    @Override
    public String sayHello(User user) throws RemoteException {
        System.out.println("this user :"+user.getAge()+"name :"+user.getName());
        return user.getName();
    }
}
