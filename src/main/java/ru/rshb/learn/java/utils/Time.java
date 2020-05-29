package ru.rshb.learn.java.utils;

import java.util.concurrent.TimeUnit;

public class Time {

    /**
     * замерить время работы метода в миллисекундах
     *
     * @param method метод для замера
     * @return время работы
     */
    public static long timerMS(Runnable method) {
        long time = System.currentTimeMillis();
        method.run();
        time = System.currentTimeMillis() - time;
        return TimeUnit.MILLISECONDS.convert(time, TimeUnit.MILLISECONDS);
    }

    /**
     * замерить время работы метода в наносекундах
     *
     * @param method метод для замера
     * @return время работы
     */
    public static long timerNS(Runnable method) {
        long time = System.nanoTime();
        method.run();
        time = System.nanoTime() - time;
        return TimeUnit.NANOSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }
}
