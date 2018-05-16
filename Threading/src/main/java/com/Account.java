package com;

public class Account {
    private Integer balance = 50;

    public Integer getBalance() {
        return balance;
    }

    public void withdraw(Integer amt) {
        balance -= amt;
    }
}
