package com;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
https://www.hackerrank.com/challenges/grid-challenge/problem
INPUT:
1
5
ebacd
fghij
olmkn
trpqs
xywuv
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
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
        //minimumAbsoluteDifference(3, (Integer[]) Arrays.asList(3,-7,0).toArray());

        //System.out.println(gridChallenge((String[]) Arrays.asList("abcde", "fghij", "klmno", "pqrst", "uvwxy").toArray()));
        System.out.println(gridChallenge((String[]) Arrays.asList("kc", "iu").toArray()));
        System.out.println(gridChallenge((String[]) Arrays.asList("uxf", "vof", "hmp").toArray()));
        /*
        2
2
kc
iu
3
uxf
vof
hmp
         */
    }


}