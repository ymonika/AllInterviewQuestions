package com;

import java.util.Arrays;
import java.util.Vector;

/*

Input :
{4 6 5 3 3 1}

Output: {3, 3, 1}
3


Input:
{1, 2, 1, 2, 4, 4, 5, 5, 5}

Output: {4, 4, 5, 5, 5}
5

We choose the following multiset of integers from the array: {4, 4, 5, 5, 5}

Each pair in the multiset has an absolute difference of 1 or 0.
i.e. |4-4| = |5-5|= 0 & |4-5| = 1
so we print the number of chosen integers, 5 as our answer.

*/

public class PickingNumbers {

    static int pickingNumbers(Vector<Integer> a) {
        int count = 0;
        int freq[] = new int[100];

        for(int i=0;i<a.size();i++) {
            freq[a.get(i)]++;
        }

        for(int i=1;i<freq.length;i++) {
            count = Math.max(count, freq[i-1]+freq[i]);
        }

        return count;
    }

    public static void main(String[] args) {

        Integer[] a = {1, 2, 1, 2, 4, 4, 5, 5, 5};
        Vector<Integer> vector = new Vector<>();
        vector.addAll(Arrays.asList(a));
        System.out.println(pickingNumbers(vector));
    }
}
