package com.ru.usty.threads;

/**
 * Created by Drayker on 2/3/2017.
 */
public class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        Solver.findAndPrintSolution(Problematic.nextProblem());
    }
}
