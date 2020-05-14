package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passanger extends Thread {
    Semaphore semaphore;
    private int id;
    CountDownLatch countDownLatch;

    public Passanger (Semaphore semaphore, int id, CountDownLatch countDownLatch) {
        this.semaphore = semaphore;
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println(" К кассе подошел человек с номером " + id);
            Thread.sleep(500);
            System.out.println(" Человек с номером " + id + "сел в автобус");

            semaphore.release();

            countDownLatch.countDown();
            countDownLatch.await();
            if (getId() == 100) {
                System.out.println("Автобус заполнен и едет в город Ош ");
            }
        } catch (Exception e) {
        }
    }
}

