package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
            Semaphore semaphore = new Semaphore(4,true);
            CountDownLatch countDownLatch = new CountDownLatch(100);
            for (int i = 1; i <= 100; i++) {
                new Passanger(semaphore, i, countDownLatch).start();


            }
        }
    }



