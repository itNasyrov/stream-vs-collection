package ru.rshb.learn.java.stream.vscollect;

import java.util.List;
import java.util.stream.Collectors;

public class SkipLimit {

    static void stream(List<Integer> list) {
        int n = list.size();

        list.stream()
                .limit((int )(n * 0.91))
                .skip((int )(n * 0.9))
                .collect(Collectors.toList());
    }

    static void parallelStream(List<Integer> list) {
        int n = list.size();

        list.parallelStream()
                .limit((int )(n * 0.91))
                .skip((int )(n * 0.9))
                .collect(Collectors.toList());
    }

    static void collection(List<Integer> list) {
        int n = list.size();

        list.subList((int )(n * 0.9), (int )(n * 0.91))
                .stream()
                .collect(Collectors.toList());
    }

}
