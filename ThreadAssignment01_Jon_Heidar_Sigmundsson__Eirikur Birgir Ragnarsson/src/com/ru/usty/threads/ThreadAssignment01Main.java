package com.ru.usty.threads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadAssignment01Main {

    private static final int NUMBER_OF_PROBLEMS = 30;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Solutions:");
        long startTime = System.currentTimeMillis();

        ArrayList<Future<Runnable>> Fute = new ArrayList<>();


        ExecutorService Serv = Executors.newFixedThreadPool(NUMBER_OF_PROBLEMS);

        for (int i = 0; i < NUMBER_OF_PROBLEMS; i++){
            Future New = Serv.submit(new ThreadRunnable());
            Fute.add(New);
        }

        for (Future<Runnable> F : Fute){
            F.get();
        }
        Serv.shutdown();

        System.out.println("All done");

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
