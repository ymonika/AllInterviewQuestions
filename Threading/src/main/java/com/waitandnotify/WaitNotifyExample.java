package com.waitandnotify;

public class WaitNotifyExample {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        new Reader(c).start();
        new Reader(c).start();
        new Reader(c).start();
        c.start();

    }

}

class Reader extends Thread {
    Calculator c;

    public Reader(Calculator c) {
        this.c=c;
    }

    public void run() {
        synchronized (c) {
            try {
                c.wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(c.getTotal());
        }
    }
}

class Calculator extends Thread {

    int total;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                total += i;
            }
            this.notify();
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
