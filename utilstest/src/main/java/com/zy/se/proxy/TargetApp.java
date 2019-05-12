package com.zy.se.proxy;

import java.lang.reflect.Proxy;

public class TargetApp {

    public static void main(String[] args){

        TargetObjHandler targetObjHandler = new TargetObjHandler();
        targetObjHandler.setTarget(new TargetObj());

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(TargetApp.class.getClassLoader(), TargetObj.class.getInterfaces(), targetObjHandler);

        //调用代理对象的方法
        proxy.run();

    }
}
