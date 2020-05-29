package ru.rshb.learn.java.stream.vscollect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Distinct {

    static void stream(List<Integer> list) {
        list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    static void parallelStream(List<Integer> list) {
        list.parallelStream()
                .distinct()
                .collect(Collectors.toList());
    }

    static void collection(List<Integer> list) {
        Set set =  new HashSet<>(list);
        List result = new ArrayList(set);
    }

}
