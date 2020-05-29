package ru.rshb.learn.java.stub;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static List<Integer> arrInt = new ArrayList<>();

    public static List<Integer> getArrInt(int count) {
        int i = 0;
        arrInt.clear();
        while (i < count) {
            arrInt.add((int) (Math.random() * 100));
            i++;
        }
        return arrInt;
    }
}
