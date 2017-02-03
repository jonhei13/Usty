package com.ru.usty.threads;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Drayker on 2/3/2017.
 */
public class ThreadRunnable2 implements Runnable{
    private CountDownLatch wait;
    public ThreadRunnable2(){

    }
    public ThreadRunnable2(CountDownLatch waiting)
    {
        this.wait = waiting;
    }
    @Override
    public void run() {
        try {
            wait.await();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        Solver.findAndPrintSolution(Problematic.nextProblem());
    }
}
