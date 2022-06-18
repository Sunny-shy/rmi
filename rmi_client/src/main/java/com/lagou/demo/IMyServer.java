package com.lagou.demo;



import com.lagou.pojo.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author ADMIN
 * @date 2022/6/16 22:06
 */
public interface IMyServer extends Remote {
    /**
     * jiekou
     * @return
     * @throws RemoteException
     */
    public String sayHello(User user) throws RemoteException;
}
