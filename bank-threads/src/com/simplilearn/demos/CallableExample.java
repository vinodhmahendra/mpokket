package com.simplilearn.demos;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) {

//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
        Callable<String> task  =  new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return  "Hello World";
            }
        };

        ExecutorService executer =Executors.newSingleThreadExecutor();

        Future<String> future =  executer.submit(task);

        try {
            String result = future.get();
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            executer.shutdown();
        }
    }
}
