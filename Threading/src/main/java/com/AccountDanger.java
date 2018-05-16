package com;

public class AccountDanger implements Runnable {
    Account acc = new Account();

    public static void main(String[] args) {
        AccountDanger accountDanger = new AccountDanger();

        Thread one = new Thread(accountDanger);
        one.setName("Fred");
        Thread two = new Thread(accountDanger);
        two.setName("Lucy");
        one.start();
        two.start();

    }

    public void run() {
        for(int i= 0;i<5 ;i ++) {
            makeWithdraw(10);
            if(acc.getBalance() < 0) {
                System.out.println("System is overdrawn");
            }
        }
    }

    private synchronized void makeWithdraw(int amt) {
        if(acc.getBalance() >= amt) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
            acc.withdraw(amt);
            System.out.println(Thread.currentThread().getName() + " completes the withdraw");
        } else {
            System.out.println("Not enough in account for "
                    + Thread.currentThread().getName()
                    + " to withdraw " + acc.getBalance());
        }
    }
}
