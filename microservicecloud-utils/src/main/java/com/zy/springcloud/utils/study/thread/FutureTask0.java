package com.zy.springcloud.utils.study.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class FutureTask0 implements Callable<Integer> {
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return new Random().nextInt();
    }
}
