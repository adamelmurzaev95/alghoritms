package com.company.linked_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        System.out.print("Linked");
        add(new LinkedList<>());
        //_______________________________________________________
        System.out.println("--------------------------------------");
        System.out.print("Array");
        add(new ArrayList<>());
    }

    public static void add(List<Integer> list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            list.add(0, i);
        }
        for (int i = 0; i < 100000; i++){
            list.remove(0);
        }
        long finish = System.currentTimeMillis();
        System.out.println("List - " + (finish - start));
    }
}
