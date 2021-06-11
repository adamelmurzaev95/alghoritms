package com.company.linkedlist;

import java.util.Arrays;

public class MyLinkedList {
    private Node root;
    private int size;
    public void add(int value) {
        //первое добавление в список
        if (root == null){
            root = new Node(value);
        }
        else{
            Node node = root;
            while (node.getNextNode() != null){
                node = node.getNextNode();
            }
            node.setNextNode(new Node(value));
        }
        size++;
    }

    public int get(int index){
        int currentIndex = 0;
        Node node = root;
        while (node != null) {
            if (currentIndex == index) return node.getValue();
            else {
                node = node.getNextNode();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void remove(int index) {
        if (index >= size) return;
        if (index == 0) {
            root = root.getNextNode();
            size--;
            return;
        }
        int currentIndex = 0;
        Node node = root;
        while (node != null) {
            if (currentIndex == index - 1) {
                node.setNextNode(node.getNextNode().getNextNode());
                size--;
                break;
            } else {
                node = node.getNextNode();
                currentIndex++;
            }
        }
    }

    @Override
    public String toString(){
        int[] array = new int[size];
        int index = 0;
        Node node = root;
        while (node != null){
            array[index++] = node.getValue();
            node = node.getNextNode();
        }
        return Arrays.toString(array);
    }

    private static class Node{
        private Node nextNode;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
