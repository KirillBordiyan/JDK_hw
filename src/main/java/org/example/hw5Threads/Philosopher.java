package org.example.hw5Threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {

    private String name;
    private int leftFork, rightFork;
    private int eatTimes;
    private CountDownLatch cdl;
    private Table table;
    private Random rnd;

    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl) {
        this.table = table;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        eatTimes = 0;
        rnd = new Random();
    }


    @Override
    public void run() {
        while (eatTimes < 3) {
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void eating() throws InterruptedException {
        if (table.tryTakeForks(leftFork, rightFork)) {
            System.out.println(name + " взял и кушает " + leftFork + " и " + rightFork + " вилками");
            sleep(rnd.nextLong(5000, 7000));
            table.putForksBack(leftFork, rightFork);
            System.out.println(name + " покушал и вернул "
                    + leftFork + " и " + rightFork + " вилки. Теперь мыслит");
            eatTimes++;
        }
    }

    private void thinking() throws InterruptedException {
        sleep(rnd.nextLong(1000, 2000));
    }


}
