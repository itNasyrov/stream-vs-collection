package ru.rshb.learn.java.stream.vscollect;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    static void stream(List<Integer> list) {
        list.stream()
                .filter(o -> o > 50)
                .collect(Collectors.toList());
            ;
    }

    static void parallelStream(List<Integer> list) {
        list.parallelStream()
                .filter(o -> o > 50)
                .collect(Collectors.toList());
    }

    static void collection(List<Integer> list) {
        list.removeIf(o -> o > 50);
    }

}
