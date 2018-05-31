package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem
Sample Input 0
5
1 1 1 3 3
Sample Output 0
1 3 3

*/
public class MaxPerimeterTriangle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Integer [] stick = new Integer[N];
        for (int i = 0; i < N; i++) {
            stick[i] = scan.nextInt();
        }
        scan.close();
        findTriangle(stick);
    }

    private static void findTriangle(Integer [] stick) {
        Arrays.sort(stick, Collections.reverseOrder());
        for (int i = 0; i < stick.length - 2; i++) {
            if (stick[i] < stick[i+1] + stick[i+2]) {
                System.out.println(stick[i+2] + " " + stick[i+1] + " " + stick[i]);
                return;
            }
        }
        System.out.println(-1);
    }
}