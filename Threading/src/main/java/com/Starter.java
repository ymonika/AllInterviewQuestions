package com;

public class Starter implements Runnable {

    void go(long id) {
        System.out.println(id);
    }
    public static void main(String[] args) {
        System.out.print(Thread.currentThread().getId() + " ");
       new Thread(new Starter()).start();

    }
    public void run() {
        go(Thread.currentThread().getId());
    }

}
