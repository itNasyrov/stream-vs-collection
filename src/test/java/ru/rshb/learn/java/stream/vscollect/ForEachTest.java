package ru.rshb.learn.java.stream.vscollect;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import ru.rshb.learn.java.stub.Data;
import ru.rshb.learn.java.utils.Time;

import java.util.List;

public class ForEachTest {

    private List<Integer> data;

    @Before
    @BeforeAll
    public void setUp() {
        data = Data.getArrInt(1_000_000);
    }

    @Test
    public void stream() {
        long time = Time.timerMS(() -> ForEach.stream(data));
        System.out.println("ForEach.stream - " + time);
    }

    @Test
    @RepeatedTest(100)
    public void paralellStream() {
        long time = Time.timerMS(() -> ForEach.paralellStream(data));
        System.out.println("ForEach.paralellStream - " + time);
    }

    @Test
    public void collection() {
        long time = Time.timerMS(() -> ForEach.collection(data));
        System.out.println("ForEach.collection - " + time);
    }
}