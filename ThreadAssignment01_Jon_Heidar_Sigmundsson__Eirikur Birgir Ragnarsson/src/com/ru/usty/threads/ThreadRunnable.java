package com.ru.usty.threads;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Drayker on 2/3/2017.
 */
public class ThreadRunnable implements Runnable{
    public ThreadRunnable(){

    }
    @Override
    public void run() {
        Solver.findAndPrintSolution(Problematic.nextProblem());
    }
}
