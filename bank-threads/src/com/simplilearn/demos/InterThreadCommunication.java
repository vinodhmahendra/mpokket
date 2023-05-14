package com.simplilearn.demos;

public class InterThreadCommunication {

    private static Object lock = new Object();
    private static boolean isReady = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(
                () -> {
                    synchronized (lock){
                        while ((!isReady)) {
                            try {
                                lock.wait(); // t1 will be in wait pool
                            }catch(InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Thread 1  is running");
                    }
                }
        );

        System.out.println(t1.getState());

        Thread  t2 = new Thread(
                ()-> {
                    synchronized (lock){
                        System.out.println("Thread 2 is running");
                        isReady = true;
                        lock.notifyAll(); // wait pool ---> lock pool
                    }
                }
        );

        t1.start();
        System.out.println(t1.getState());
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());
    }
}
