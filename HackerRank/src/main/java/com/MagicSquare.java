package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You will be given a  matrix  of integers in the inclusive range [1, 9] .
We can convert any digit "a" to any other digit "b" in the range at cost of |a-b|.
Given convert it into a magic square at minimal cost. Print this cost on a new line

Input:
5 3 4
1 5 8
6 4 2

Output:
7

This matrix can be converted into below matrix with cost of |5-8|+|8-9|+|4-7| = 7
8 3 4
1 5 9
6 7 2

*/


public class MagicSquare {

    static List<int[][]> magicSq = new ArrayList<>();

    static {
        int[][] a1 = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        int[][] a2 = {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        int[][] a3 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        int[][] a4 = {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}};
        int[][] a5 = {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
        int[][] a6 = {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        int[][] a7 = {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
        int[][] a8 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};

        magicSq.add(a1);
        magicSq.add(a2);
        magicSq.add(a3);
        magicSq.add(a4);
        magicSq.add(a5);
        magicSq.add(a6);
        magicSq.add(a7);
        magicSq.add(a8);
    }

    static int[] sumArray = new int[8];

    static int matrixSubtraction(int[][] arrayA, int[][] arrayB) {
        int[][] value = new int[3][3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value[i][j] = Math.abs(arrayA[i][j] - arrayB[i][j]);
                sum += value[i][j];
            }
        }
        return sum;
    }

    static int formingMagicSquare(int[][] s) {
        int index = 0;
        for (int[][] matrix : magicSq) {
            sumArray[index] = matrixSubtraction(s, matrix);
            index++;
        }
        Arrays.sort(sumArray);
        return sumArray[0];
    }

    public static void main(String[] args) {
    int[][] a = {{4, 9, 1},
            {6, 3, 6},
            {5, 2, 8}};
        System.out.println(formingMagicSquare(a));

    }
}
