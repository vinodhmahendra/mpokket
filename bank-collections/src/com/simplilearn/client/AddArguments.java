package com.simplilearn.client;

public class AddArguments {

    public static void main(String[] args) {
        int sum  = 0;
        for ( String element : args) {
            sum += Integer.parseInt(element);
        }
        System.out.println("Sum = " + sum);
    }
}
