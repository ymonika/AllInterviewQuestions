package com;

public class PrintLetters implements Runnable {

    private StringBuffer letter;

    public PrintLetters(StringBuffer letter) {
        this.letter = letter;
    }

    public void run() {
        synchronized (letter) {
            for (int i = 0; i < 100; i++)
                System.out.print(letter);
                char temp = letter.charAt(0);
                temp++;
                letter.setCharAt(0, temp);
        }
    }

    public static void main(String[] args) {
        PrintLetters printLetters = new PrintLetters(new StringBuffer("A"));

        Thread one = new Thread(printLetters);
        one.start();

        Thread two = new Thread(printLetters);
        two.start();

        Thread three = new Thread(printLetters);
        three.start();
    }
}
