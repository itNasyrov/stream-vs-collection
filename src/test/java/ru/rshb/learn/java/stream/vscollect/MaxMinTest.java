package ru.rshb.learn.java.stream.vscollect;

import org.junit.Before;
import org.junit.Test;
import ru.rshb.learn.java.stub.Data;
import ru.rshb.learn.java.utils.Time;

import java.util.List;

public class MaxMinTest {

    private List<Integer> data;

    @Before
    public void setUp() {
        data = Data.getArrInt(10_000_000);
    }

    @Test
    public void stream() {
        long time = Time.timerMS(() -> MaxMin.stream(data));
        System.out.println("MaxMin.stream - " + time);
    }

    @Test
    public void parallelStream() {
        long time = Time.timerMS(() -> MaxMin.parallelStream(data));
        System.out.println("MaxMin.parallelStream - " + time);
    }

    @Test
    public void collection() {
        long time = Time.timerMS(() -> MaxMin.collection(data));
        System.out.println("MaxMin.collection - " + time);
    }
}