package com.ru.usty.threads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadAssignment01Main {

    private static final int NUMBER_OF_PROBLEMS = 30;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Solutions:");



    //=============== Number 1 =================

        Thread[] threads = new Thread[NUMBER_OF_PROBLEMS];
        long startTime = System.currentTimeMillis();
/*
        for (int i = 0; i < NUMBER_OF_PROBLEMS; i++){
            threads[i] = new Thread(new ThreadRunnable());
        }

        for (Thread thread : threads){
            thread.start();
            thread.join();
        }
        System.out.println("Number 1 All done");
        System.out.println("All done");

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
*/
    //=============== Number 3 =================

        startTime = System.currentTimeMillis();
        ArrayList<Future<Runnable>> Fute = new ArrayList<>();

        ExecutorService Serv = Executors.newFixedThreadPool(6);

        for (int i = 0; i < NUMBER_OF_PROBLEMS; i++){
            Future New = Serv.submit(new ThreadRunnable());
            Fute.add(New);
        }

        for (Future<Runnable> F : Fute){
            F.get();
        }
        Serv.shutdown();

        System.out.println("Number 3 All done");
        System.out.println("All done");

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");

    }

}
