package com.joinexample;

public class JoinExample implements Runnable {

    public void run()  {
        System.out.println("inside RUN method...." + Thread.currentThread().getName());
        try {
            Thread.sleep(1000l);
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " +  i );
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(new JoinExample());
        t2.setName("t2");
        t2.start();
        t2.join();

        Thread t1 = new Thread(new JoinExample());
        t1.setName("t1");
        t1.start();

    }

}
