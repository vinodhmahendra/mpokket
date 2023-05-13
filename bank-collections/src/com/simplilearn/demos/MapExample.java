package com.simplilearn.demos;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice",25);
        ages.put("Bob",30);
        ages.put("Alice",27);

        System.out.println(ages.get("Alice"));
    }
}
