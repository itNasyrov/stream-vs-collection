package ru.rshb.learn.java.stream.vscollect;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.rshb.learn.java.stub.Data;
import ru.rshb.learn.java.utils.Time;

import java.util.List;

@FixMethodOrder(MethodSorters.JVM)
public class DistinctTest {

    private List<Integer> data;

    @Before
    public void setUp() {
        data = Data.getArrInt(100_000_000);
    }

    @Test
    public void stream() {
        long time = Time.timerMS(() -> Distinct.stream(data));
        System.out.println("Distinct.stream - " + time);
    }

    @Test
    public void parallelStream() {
        long time = Time.timerMS(() -> Distinct.parallelStream(data));
        System.out.println("Distinct.parallelStream - " + time);
    }

    @Test
    public void collection() {
        long time = Time.timerMS(() -> Distinct.collection(data));
        System.out.println("Distinct.collection - " + time);
    }


}