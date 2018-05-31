package com;

public class WaitTest {
    /*public static void main(String[] args) {
        System.out.print("1 ");
        synchronized (args) {
            System.out.print("2 ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("3 ");
    }*/
    public static  void main(String[] args) {

        Thread t = new Thread();
        synchronized(t) {
        t.start();
        System.out.print("X");

            try {
                t.wait(10000);
            } catch (InterruptedException e) {
            }
            System.out.print("Y");
        }
    }
}
