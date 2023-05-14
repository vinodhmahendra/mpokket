package com.simplilearn.demos;



public class RaceCondition {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable runnable = () -> {
            //define a task
            for (int i = 0 ; i < 1000 ; i ++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState());
        thread2.start();
//        System.out.println("Counter value : " + counter.getCount());
        //Wait here for the other thread to finish
        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println("Counter value : " + counter.getCount());
//        System.out.println(thread1.getState());

//        Thread.yield();

    }
}

//shared object
class Counter {
    private int count = 0 ;

    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}