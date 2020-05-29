package ru.rshb.learn.java.stream.vscollect;

import java.util.List;

public class Count {

    static void stream(List list) {
        list.stream().count();
    }

    static void collection(List list) {
        list.size();
    }

}
