package ru.baROM.pr3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeCounter {

    private int data;
    private Lock lock = new ReentrantLock();

    public SafeCounter(int data) {
        this.data = data;
    }

    public void inc() throws InterruptedException {
        lock.lock();
        try {
            data ++;
        } finally {
            lock.unlock();
        }
    }

    public void dec() throws InterruptedException {
        lock.lock();
        try {
            data--;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
