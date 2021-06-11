package com.company.linkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 1; i < 11; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList);
        linkedList.remove(3);
        linkedList.remove(9);
        linkedList.remove(0);
        System.out.println(linkedList);
    }
}
