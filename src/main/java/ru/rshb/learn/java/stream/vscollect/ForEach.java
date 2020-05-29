package ru.rshb.learn.java.stream.vscollect;

import java.util.List;

public class ForEach {

    static void stream(List<Integer> list) {
        list.stream().forEach(i -> i *= i);
    }

    static void paralellStream(List<Integer> list) {
        list.stream()
                .forEach(i -> i *= i);
    }

    static void collection(List<Integer> list) {
        list.forEach(i -> i *= i);
    }

}
