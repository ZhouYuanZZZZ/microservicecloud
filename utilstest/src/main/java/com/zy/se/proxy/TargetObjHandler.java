package com.zy.se.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TargetObjHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName());

        System.out.println("run before");
        method.invoke(target,args);
        System.out.println("run after");
        return null;
    }
}
