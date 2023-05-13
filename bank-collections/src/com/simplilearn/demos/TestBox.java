package com.simplilearn.demos;

import java.util.ArrayList;
import  java.util.List;
public class TestBox {

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(new Integer(4));;
//        integerBox.set(new Double(4.0));;
        Integer getInteger = integerBox.get();

        Box<String> stringBox = new Box<>();
        stringBox.set(new String("Hello World"));
        String geString = stringBox.get();


//        List list = new ArrayList();
//        list.add(4);
//        list.add("string");

//        for (Object obj : list){
////            System.out.println(obj);
//        }

        List<Integer> list = new ArrayList<>();
        list.add(4);
//        list.add("string"); error


    }
}
