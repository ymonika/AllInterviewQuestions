package clock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BerlinClock {

    static String[] fiveHours = new String[4];
    static String[] oneHour = new String[4];
    static String[] fiveMins = new String[11];
    static String[] oneMin = new String[4];
    public static int FIVE = 5;

    private static void resetAll() {
        fiveHours = new String[4];
        oneHour = new String[4];
        fiveMins = new String[11];
        oneMin = new String[4];
    }

    public static void main(String[] args) {
        String[] strArray = {"10:00", "00:05", "23:29", "23:59", "00:05"};
        for (String str : strArray) {
            resetAll();
            System.out.println("TIME: " + str);
            List<Integer> timeArray = Arrays.stream(str.split(":")).map(strInt -> Integer.parseInt(strInt)).collect(Collectors.toList());
            Integer hours = timeArray.get(0);
            Integer mins = timeArray.get(1);

            setTime(fiveHours, oneHour, hours, FIVE);
            setTime(fiveMins, oneMin, mins, FIVE);

            System.out.println("FIVE HOUR : " + Arrays.deepToString(fiveHours));
            System.out.println("ONE HOUR  : " + Arrays.deepToString(oneHour));
            System.out.println("FIVE MIN. : " + Arrays.deepToString(fiveMins));
            System.out.println("ONE MIN.  :" + Arrays.deepToString(oneMin));
            System.out.println("____________________________________________________\n");
        }
    }


    public static void setTime(String[] array1, String[] array2, Integer hours, Integer hourOrMin) {
        int d = hours / hourOrMin;
        setArray(array1, d);
        int r = hours % hourOrMin;
        setArray(array2, r);
    }

    public static void setArray(String[] array, Integer maxLimit) {
        for (int i = 0; i < maxLimit; i++) {
            array[i] = "=";
        }
    }
}
