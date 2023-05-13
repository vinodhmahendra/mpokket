package com.simplilearn.client;

import java.io.FileNotFoundException;

public class SampleFile {
    public static void main(String[] args) throws Exception { // handle rule
        try {
//            trouble();

           throw new Exception("ip");
        }catch(Exception variable) {
           throw new Exception(variable); // rethrowing
            //throw propagate
        }

    }
   static void trouble() throws Exception { // declare rule
       throw new Exception("common exception");
//       int x  = 10 /0;
    }
}
