package ru.rshb.learn.java.stream.vscollect;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

    static int stream(List<Integer> list) {
        return list.stream().max(Comparator.naturalOrder()).get();
    }

    static int parallelStream(List<Integer> list) {
        return list.parallelStream().max(Comparator.naturalOrder()).get();
    }

    static int collection(List<Integer> list) {
        return Collections.max(list, Comparator.naturalOrder());
    }

}
