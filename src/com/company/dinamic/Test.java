package com.company.dinamic;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        int n = 3; //число строк = число вещей
        int k = 4; //грузоподъёмность рюкзака
//массив вещей
        Item[] items = {new Item("гитара", 1, 1500),
                new Item("бензопила", 4, 3000),
                new Item("ноутбук", 3, 2000)};
//массив промежуточных состояний рюкзака
        Backpack[][] bp = new Backpack[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (i == 0 || j == 0) {
                    bp[i][j] = new Backpack(new Item[]{}, 0);
                } else if (i == 1) {
                    bp[i][j] = items[0].getWeight() <= j ?
                            new Backpack(new Item[]{items[0]}, items[0].getPrice()) : new Backpack(new Item[]{}, 0);
                } else {
                    if (items[i - 1].getWeight() > j)
                        bp[i][j] = bp[i - 1][j];
                    else {
                        int newPrice = items[i - 1].getPrice() + bp[i - 1][j - items[i - 1].getWeight()].getPrice();
                        if (bp[i - 1][j].getPrice() > newPrice) {
                            bp[i][j] = bp[i - 1][j];
                        } else
                            bp[i][j] = new Backpack(
                                    Stream.concat(Arrays.stream(new Item[]{items[i - 1]}),
                                            Arrays.stream(bp[i - 1][j - items[i - 1].getWeight()].getItems()))
                                            .toArray(Item[]::new), newPrice);
                    }
                }
            }
        }
        System.out.println(bp[bp.length - 1][bp[0].length - 1].getDescription());
    }
}
