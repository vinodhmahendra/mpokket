package com.simplilearn.demos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice"); // Duplicate value , will be ignored
        System.out.println(names);

//        Iterator<String> i = names.iterator();
//        while ( i.hasNext()) {
//            System.out.println(i.next());
//        }
        Optional<String> found = names.stream().filter(s -> s.equals("Bob")).findFirst();
        if ( found.isPresent()) {

        }else  {

        }


    }
}
