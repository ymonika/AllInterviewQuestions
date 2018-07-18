package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

/*

Find out Alice's rank for below scores, Score are sorted in descending order

Scores:
100 100 50 40 40 20 10

Alice Score:
5 25 50 120

Ranks:
6 4 2 1

*/

public class ClimbingTheLeaderboard {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int[] ranks = new int[alice.length];
        HashSet<Integer> setU = new HashSet();
        for (int a : scores) {
            setU.add(a);
        }
        int[] set = new int[setU.size()];
        set[0] = scores[0];
        for (int i = 1, j = 0; i < scores.length; i++) {
            if (scores[i - 1] == scores[i]) {
                continue;
            } else {
                j++;
                set[j] = scores[i];
            }
        }

        int j = 0;
        for (int aliceScore : alice) {
            boolean setRank = false;
            for (int i = 0; i < set.length; i++) {
                if (aliceScore >= set[i]) {
                    setRank = true;
                    ranks[j] = i + 1;
                    j++;
                    break;
                }
            }
            if (setRank == false) {
                ranks[j] = set.length + 1;
                j++;
            }
        }
        return ranks;
    }

    static int[] solution2(int[] scores, int[] alice) {
        int n = scores.length;
        int[] array = IntStream.range(0, n).map(i -> scores[n - i - 1]).distinct().toArray();
        int index = 0;
        int ranks[] = new int[alice.length];
        int i = 0;
        for (int score : alice) {
            index = Arrays.binarySearch(array, index < 0 ? 0 : index, array.length, score);
            if (index < 0) index = -index - 2;
            ranks[i] = array.length - index;
            i++;
        }
        return ranks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);
        //int[] result = solution2(scores, alice);

    }
}
