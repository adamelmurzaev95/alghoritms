package com.company.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Search {
    public static void main(String[] args) {
        Node root = new Node(20, new Node(7, new Node(4, new Node(6)), new Node(9)),
                new Node(35, new Node(31, new Node(28)), new Node(40, new Node(38), new Node(52))));
        //System.out.println(Node.sumRecursive(root));
        System.out.println(Node.sum2(root));
    }
}

class Node{
    private int value;
    private Node left;
    private Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value, Node left) {
        this.value = value;
        this.left = left;
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public static int sumRecursive(Node root){
        int sum = 0;
        if (root.left != null)
            sum += sumRecursive(root.left);
        if (root.right != null)
            sum += sumRecursive(root.right);
        return root.value + sum;
    }

    public static int sum(Node root){
        int sum = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            sum += node.getValue();
            System.out.println(node.value);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return sum;
    }

    public static int sum2(Node root){
        int sum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            sum += node.getValue();
            System.out.println(node.value);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return sum;
    }
}
