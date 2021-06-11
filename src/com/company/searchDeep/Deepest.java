package com.company.searchDeep;

public class Deepest {


    public static int deepest(Node root) {
        int deepest = 0;
        if (root.getLeft() != null){
            deepest = Math.max(deepest, deepest(root.getLeft()));
        }
        if (root.getRight() != null){
            deepest = Math.max(deepest, deepest(root.getRight()));
        }
        return deepest + 1;
    }

    public static String test(String[] arr){
        String s = arr[0];
        for (int i = 1; i < arr.length; i++){
            while (!arr[i].contains(s)){
                 s = s.substring(0, s.length() - 1);
                System.out.println(s);
            }
        }
        return s;
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
}
