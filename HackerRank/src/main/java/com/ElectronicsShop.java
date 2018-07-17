package com;


import java.util.Arrays;

/*
Find out the pair of Usb & keyboard you can purchase within the given budget.
k: price of different keyboards
d: price of different USBs
b: budget

If you can't find any pair of USB & keyboard within budget then print -1.

*/


public class ElectronicsShop {

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxSum = -1;
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        for (int i = 0; i < drives.length; i++) {
            for (int j = 0; j < keyboards.length; j++) {
                int currentVal = drives[i] + keyboards[j];
                if (maxSum < currentVal && currentVal <= b) {
                    maxSum = currentVal;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] k = {5,2,8};
        int[] d = {3,1};
        int b = 10;
        System.out.println(getMoneySpent(k, d, b));
    }
}
