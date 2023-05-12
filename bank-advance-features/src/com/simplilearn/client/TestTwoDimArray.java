package com.simplilearn.client;

public class TestTwoDimArray {
    public static void main(String[] args) {
        int[][] twoDim = {}; // declare
//        twoDim = new int[5][5]; // rectangular array
//        twoDim = new int[5][]; // valid
       twoDim = new int[][]{ {1}, {1, 2}, {1, 2, 3}, {1, 2, 3, 4}, {1, 2, 3, 4, 5}};
//       for ( int  i = 0 ; i < twoDim.length ; i++) {
//           for  ( int j = 0 ; j < twoDim[i].length ; j++){
//               System.out.print(twoDim[i][j] + " ");
//           }
//           System.out.println();
//       }
        // twoDim ---> 5 arrays
        for ( int[] eachArray : twoDim ){
            for ( int eachElement: eachArray ){
                System.out.print(eachElement + " ");
            }
            System.out.println();
        }

        int[] n = new int[5];
        n[0] = 1;
//        System.arraycopy();
        n = new int[10];

    }
}
