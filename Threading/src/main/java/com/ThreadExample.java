package com;

public class ThreadExample extends Thread {

    public void run() {
        System.out.println("Started: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000l);
            heavyCall();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ended: " + Thread.currentThread().getName());
    }

    public void heavyCall() throws InterruptedException{
            Thread.sleep(1000l);
    }

    public static void main(String[] args) {
        ThreadExample threadExample0 = new ThreadExample();
        threadExample0.start();

        ThreadExample threadExample1 = new ThreadExample();
        threadExample1.start();
    }
}
