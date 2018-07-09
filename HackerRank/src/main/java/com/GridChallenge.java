package com;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending.
Determine if the columns are also in ascending alphabetical order,
top to bottom. Return YES if they are or NO if they are not.

For example, given:
a b c
a d e
e f g

The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order,
so the answer would be YES. Only elements within the same row can be rearranged. They cannot be moved to a different row.

INPUT:
ebacd
fghij
olmkn
trpqs
xywuv

OUTPUT:
YES

INPUT:
kc
iu

OUTPUT:
YES

*/

public class GridChallenge {

    static String gridChallenge(String[] grid) {
        int n = grid.length;
        Integer[][] array = new Integer[n][];

        int index = 0;
        for (String str : grid) {
            List<Integer> list = Arrays.stream(str.split("")).map(s -> s.charAt(0) - 'a').filter(s -> s >= 0).collect(Collectors.toList());
            Collections.sort(list);
            Integer[] arr = new Integer[n];
            array[index] = list.toArray(arr);
            index++;
        }
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[j] = array[j][i];
            }
            if (!isArraySorted(arr, arr.length)) {
                return "NO";
            }
        }
        return "YES";
    }

    static boolean isArraySorted(Integer arr[], int n) {
        if (n == 0 || n == 1)
            return true;
        for (int i = 1; i < n; i++)
            if (arr[i - 1] > arr[i])
                return false;
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(gridChallenge((String[]) Arrays.asList("abcde", "fghij", "klmno", "pqrst", "uvwxy").toArray()));
        System.out.println(gridChallenge((String[]) Arrays.asList("kc", "iu").toArray()));
        System.out.println(gridChallenge((String[]) Arrays.asList("uxf", "vof", "hmp").toArray()));

    }


}