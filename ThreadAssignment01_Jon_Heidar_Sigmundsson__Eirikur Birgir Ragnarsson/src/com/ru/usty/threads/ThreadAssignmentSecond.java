package com.ru.usty.threads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadAssignmentSecond {

    private static final int NUMBER_OF_PROBLEMS = 30;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Solutions:");

        //=============== Number 2 =================
        long startTime = System.currentTimeMillis();
        CountDownLatch l = new CountDownLatch(1);
        Thread[] threads2 = new Thread[NUMBER_OF_PROBLEMS];
        for (int i = 0; i < NUMBER_OF_PROBLEMS; i++) {
            threads2[i] = new Thread(new ThreadRunnable2(l));
        }
        for (Thread thread : threads2) {
            thread.start();
        }
        l.countDown();
        System.out.println("Number 2 All done");
        System.out.println("All done");

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");


    }
}
