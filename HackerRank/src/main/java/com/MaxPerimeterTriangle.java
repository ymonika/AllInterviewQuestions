package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
Given an array of stick lengths, use  of them to construct a non-degenerate triange
with the maximum possible perimeter. Print the lengths of its sides as space-separated integers in non-decreasing order.

If there are several valid triangles having the maximum perimeter:

Choose the one with the longest maximum side.
If more than one has that maximum, choose from them the one with the longest minimum side.
If more than one has that maximum as well, print any one them.
If no non-degenerate triangle exists, print -1.

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