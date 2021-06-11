package com.company.test;
public class Cat extends Animal<Integer> {
    public Cat(int id, Integer name) {
        super(id, name);
    }

    public void eat(){
        getName();
    }
}
