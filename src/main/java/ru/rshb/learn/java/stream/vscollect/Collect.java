package ru.rshb.learn.java.stream.vscollect;

import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.toCollection;

class Collect {

    static void stream(List<Integer> list) {
        list.stream().collect(toCollection(TreeSet::new));
    }

    static void collection(List<Integer> list) {
        new TreeSet<>(list);
    }

}
