package ru.rshb.learn.java.stream.vscollect;

import org.junit.Before;
import org.junit.Test;
import ru.rshb.learn.java.stub.Data;
import ru.rshb.learn.java.utils.Time;

import java.util.List;

public class SkipLimitTest {

    private List<Integer> data;

    @Before
    public void setUp() {
        data = Data.getArrInt(10_000_000);
    }

    @Test
    public void stream() {
        long time = Time.timerMS(() -> SkipLimit.stream(data));
        System.out.println("SkipLimit.stream - " + time);
    }

    @Test
    public void parallelStream() {
        long time = Time.timerMS(() -> SkipLimit.parallelStream(data));
        System.out.println("SkipLimit.parallelStream - " + time);
    }

    @Test
    public void collection() {
        long time = Time.timerMS(() -> SkipLimit.collection(data));
        System.out.println("SkipLimit.collection - " + time);
    }
}