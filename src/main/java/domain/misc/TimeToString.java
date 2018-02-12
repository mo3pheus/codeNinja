package domain.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class TimeToString {

    public static       Map<Integer, String> timeStrings       = new HashMap<>();
    public static final String[]             HOUR_STRING       = {"zero", "one", "two", "three", "four", "five",
                                                                  "six", "seven", "eight", "nine", "ten", "eleven",
                                                                  "twelve", "thirteen", "fourteen", "fifteen",
                                                                  "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[]             TENS_DIGIT_STRING = {"na", "1:ten", "2:twenty", "3:thirty", "4:fourty",
                                                                  "5:fifty"};
    public static final String[]             UNIT_DIGIT_STRING = {"zero", "one", "two", "three", "four", "five",
                                                                  "six", "seven", "eight", "nine"};

    public static void setUpTimeStrings() {
        timeStrings.put(new Integer(30), "half past");
        timeStrings.put(new Integer(15), "quarter past");
        timeStrings.put(new Integer(45), "quarter to");
        timeStrings.put(new Integer(0), "o' clock");
    }

    public static int getTensDigit(int m) {
        char[]        mString       = Integer.toString(m).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mString[0]);
        int tensDigit = Integer.parseInt(stringBuilder.toString());
        return tensDigit;
    }

    public static int getUnitsDigit(int m) {
        char[]        mString       = Integer.toString(m).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mString[1]);
        int unitsDigit = Integer.parseInt(stringBuilder.toString());
        return unitsDigit;
    }

    static String timeInWords(int h, int m) {
        if (m == 0) {
            return HOUR_STRING[h] + " " + timeStrings.get(m);
        } else if (timeStrings.containsKey(new Integer(m))) {
            if (m > 30) {
                h = h + 1;
            }
            return timeStrings.get(m) + " " + HOUR_STRING[h];
        } else if (m < 30) {

            return getMinutesConvertedString(m) + " minutes past " + HOUR_STRING[h];
        } else {
            m = 60 - m;
            h = h + 1;

            return getMinutesConvertedString(m) + " minutes to " + HOUR_STRING[h];
        }
    }

    public static String getMinutesConvertedString(int m) {
        String minutesString = "";

        if (m >= 20) {
            int    tensDigit        = getTensDigit(m);
            int    unitsDigit       = getUnitsDigit(m);
            String tensDigitString  = TENS_DIGIT_STRING[tensDigit].split(":")[1];
            String unitsDigitString = UNIT_DIGIT_STRING[unitsDigit];
            minutesString = tensDigitString + " " + unitsDigitString;
        } else {
            minutesString = HOUR_STRING[m];
        }
        return minutesString;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int     h  = in.nextInt();
        int     m  = in.nextInt();
        setUpTimeStrings();

        String result = timeInWords(h, m);
        System.out.println(result);
        in.close();
    }
}