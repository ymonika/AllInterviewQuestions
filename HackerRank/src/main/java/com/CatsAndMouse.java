package com;

public class CatsAndMouse {

/*
Two cats and a mouse are at various positions on a line. You will be given their starting positions.
Your task is to determine which cat will reach the mouse first, assuming the mouse doesn't move and the cats travel at equal speed.
If the cats arrive at the same time, the mouse will be allowed to move and it will escape while they fight.

If cat  catches the mouse first, print Cat A.
If cat  catches the mouse first, print Cat B.
If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes

*/

    static String catAndMouse(int x, int y, int z) {

        String result = "";
        if(Math.abs(z-x) == Math.abs(z-y)) {
            result ="Mouse C";
        } else if (Math.abs(z-x) < Math.abs(z-y)) {
            result ="Cat A";
        } else if (Math.abs(z-y) < Math.abs(z-x)) {
            result ="Cat B";
        }

        return result;
    }

    public static void main(String[] args) {
        int catA_Distance = 1;
        int catB_Distance = 2;
        int mouseC_Distance = 3;
        System.out.println(catAndMouse(catA_Distance, catB_Distance, mouseC_Distance));
        System.out.println(catAndMouse(1, 3, 2));
    }
}
