package com.simplilearn.demos;

public class Main {

    public static void main(String[] args) {

        MyRunnable target = new MyRunnable();
        Thread t = new Thread(target);
        t.start();
        
//        //create a object of MyThread
//        MyThread t  = new MyThread();
////        t.run();
//        t.start();
    }
}
