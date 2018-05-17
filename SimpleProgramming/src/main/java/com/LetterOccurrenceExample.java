package com;

public class LetterOccurrenceExample {

    public static void main(String[] args) {
        String str = "aabbcdeff";
        str = str + " ";
        char previous = str.charAt(0);
        String printString = "";
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char indexChar = str.charAt(i);
            if (previous == indexChar) {
                count++;
                previous = indexChar;
            } else {
                printString += count != 1 ? (previous + "") + count : previous;
                previous = indexChar;
                count = 1;
            }
        }
        System.out.println(printString);
    }
}