package com;

import java.util.Arrays;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/candies/problem

10
9 2 3 6 5 4 3 2 2 2


 */
public class CandiesProblem {

    static int candies(int n, int[] markings) {
        Integer[] candies = new Integer[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        candies[0] = 1;
        for(int i = 1; i < markings.length; i++) {
            candies[i] = (markings[i] > markings[i-1]) ? (candies[i-1] + 1) : 1;
        }
        for(int i = markings.length - 2; i >= 0; i--) {
            candies[i] = (markings[i] > markings[i+1] && (markings[i+1] + 1) > markings[i])
                    ? (candies[i+1] + 1) : candies[i];
        }

        return Arrays.stream(candies).mapToInt(i -> i).sum();
    }


    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(candies(n, array));
    }
}
