package com.simplilearn.client;

public class AddArguments2 {
    public static void main(String[] args) {
        try {
            int sum = 0 ;
            for ( String element : args) {
                sum = Integer.parseInt(element);
            }
            System.out.println("Sum = " + sum);
        }catch (NumberFormatException variable) {
            //handle the exception
//            variable.printStackTrace(); // dev
            System.err.println("one of the command-line arguments is not an integer.");
        }
    }
}
