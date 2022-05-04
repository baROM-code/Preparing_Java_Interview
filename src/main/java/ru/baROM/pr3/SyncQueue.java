package ru.baROM.pr3;

public class SyncQueue {
    boolean flag = false;

    public synchronized void ping() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ping");
        flag = true;
        notify();
    }

    public synchronized void pong() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("  Pong");
        flag = false;
        notify();
    }
}
