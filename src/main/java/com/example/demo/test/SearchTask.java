package com.example.demo.test;

import java.util.concurrent.locks.ReentrantLock;

public class SearchTask implements Runnable {
    private static final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        int i=1;
    while (i-->0){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i+","+Thread.currentThread().getName());
    }
    }
}
