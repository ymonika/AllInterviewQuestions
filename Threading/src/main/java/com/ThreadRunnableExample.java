package com;

public class ThreadRunnableExample implements Runnable {

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

    public void heavyCall() {
        try {
            Thread.sleep(3000l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadRunnableExample threadExampleRunnable = new ThreadRunnableExample();

        Thread thread0 = new Thread(threadExampleRunnable);
        thread0.start();

        Thread thread1 = new Thread(threadExampleRunnable);
        thread1.start();

    }
}
