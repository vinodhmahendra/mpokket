package com.simplilearn.demos;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ListExample {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println(fruits.get(1));

        List<Map<String,Object>> students = new ArrayList<>();

        Map<String, Object> student1 = new HashMap<>();
        student1.put("name","Alice");
        student1.put("age",20);

        students.add(student1);

        Map<String, Object> student2 = new HashMap<>();
        student2.put("name","Bob");
        student2.put("age",22);

        students.add(student2);

        Map<String, Object> student3 = new HashMap<>();
        student3.put("name","Bob");
        student3.put("age",22);

        students.add(student3);

//        for (Map<String,Object> student: students) {
//            System.out.println("Name: " + student.get("name"));
//            System.out.println("Age: " + student.get("age"));
//        }
        System.out.println(students);
    }
}
