package com.simplilearn.demos;

public class DeadLock {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(
                ()->{
                    synchronized (lock1) {
                        System.out.println("Thread1 acquired lock1");
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2){
                            System.out.println("Thread1 acquired lock2");
                        }
                    }
                }
        );

        Thread t2 = new Thread(
                ()->{
                    synchronized (lock1) {
                        System.out.println("Thread2 acquired lock1");
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2){
                            System.out.println("Thread2 acquired lock2");
                        }
                    }
                }
        );

//        Thread t2 = new Thread(
//                ()->{
//                    synchronized (lock2) {
//                        System.out.println("Thread2 acquired lock2");
//                        try {
//                            Thread.sleep(1000);
//                        }catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        synchronized (lock1){
//                            System.out.println("Thread1 acquired lock1");
//                        }
//                    }
//                }
//        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
