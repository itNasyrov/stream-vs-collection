package ru.rshb.learn.java.stream.vscollect;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {

    static void stream(List<Integer> list) {
        list.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    static void parallelStream(List<Integer> list) {
        list.parallelStream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    static void collection(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
    }

}
