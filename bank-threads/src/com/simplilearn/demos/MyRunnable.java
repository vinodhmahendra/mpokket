package com.simplilearn.demos;

// better object-oriented design
// single inheritance
// consistency
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}
