package com.simplilearn.client;

public class AddArguments3 {

    public static void main(String[] args) {
        int sum  = 0;
        for ( String element : args) {
            try {
                sum += Integer.parseInt(element);
            }catch (NumberFormatException variable) {
                System.err.println("[" + element+"] is not an integer and will not be included in the sum");
            }
        }
        System.out.println("Sum = " + sum);
    }
}
