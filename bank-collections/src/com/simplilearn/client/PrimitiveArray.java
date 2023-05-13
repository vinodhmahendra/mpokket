package com.simplilearn.client;

public class PrimitiveArray {

    public static char[] createArray() {
        char[] s;

        s = new char[26];

        for ( int i = 0 ; i < 26 ; i++) {
            s[i] = (char) ( 'A' + i );
        }
        return s;
    }

    public static void main(String[] args) {
        char[] characters = createArray();
        printElements ( characters );

    }

    private static void printElements(char[] anArray) {
//        for (int i = 0 ; i < c.length; i++){
//            System.out.println(c[i]);
//        }

        for ( char element : anArray) {
            System.out.println(element);
        }
    }
}
