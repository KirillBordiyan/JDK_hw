package org.example.hw5Threads;

import javax.naming.InsufficientResourcesException;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread {
    private final int PHILOSOPHERS_COUNT = 5;
    private Fork[] forks;
    private Philosopher[] philosophers;
    private CountDownLatch cdl;


    public Table() {
        forks = new Fork[PHILOSOPHERS_COUNT];
        philosophers = new Philosopher[PHILOSOPHERS_COUNT];
        cdl = new CountDownLatch(PHILOSOPHERS_COUNT);
        autoInput();
    }

    @Override
    public void run() {
        System.out.println("Трапеза началась");
        try {
            thinking();
            //тут await нужен, ведь в главном потоке main такой объект ничего не ждет от другого потока
            //если бы этот поток+такой же использовали что-то одно, то приходилось бы ждать (wait())
            //а так, мы просто ждем выполнения асинхронных методов (которые не в main)
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Трапеза окончена");
    }

    public synchronized boolean tryTakeForks(int leftFork, int rightFork) {
        if (!forks[leftFork].isUsing() && !forks[rightFork].isUsing()) {
            forks[leftFork].setUsing(true);
            forks[rightFork].setUsing(true);
            return true;
        }
        return false;
    }

    public void putForksBack(int leftFork, int rightFork) {
        forks[leftFork].setUsing(false);
        forks[rightFork].setUsing(false);
    }

    private void thinking() {
        for (Philosopher ph : philosophers) {
            ph.start();
        }
    }

    private void autoInput() {
        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            forks[i] = new Fork();
            philosophers[i] = new Philosopher(
                    "Philosopher №" + i,
                    this,
                    i,
                    (i + 1) % PHILOSOPHERS_COUNT, cdl);
        }

    }
}
