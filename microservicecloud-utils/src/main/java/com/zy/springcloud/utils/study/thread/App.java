package com.zy.springcloud.utils.study.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args)   {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                5,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(2),
                new ThreadPoolExecutor.DiscardPolicy());

        ArrayList<FutureTask> futureTasks = new ArrayList<FutureTask>();
        for (int i = 0; i <10 ; i++) {
            FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(new FutureTask0());
            futureTasks.add(integerFutureTask);

            threadPoolExecutor.submit(integerFutureTask);
        }

        for (FutureTask item:futureTasks) {
            try {
                System.out.println(item.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }


}
