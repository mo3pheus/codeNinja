package domain.misc;

import java.util.HashMap;
import java.util.Map;

public class ObjectEncoding {
    static Map<String, Integer> priceMap = new HashMap<>();

    static void showEncodedOutput(String[] makers, String maker) {
        int[] encodedObject = new int[makers.length];
        encodedObject[findIndex(makers, maker)] = 1;
        System.out.print(priceMap.get(maker) + " ");
        for (int i : encodedObject) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    static int findIndex(String[] makers, String maker) {
        int index = -1;

        for (int i = 0; i < makers.length; i++) {
            if (makers[i].equals(maker)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Object Encoding");

        String[] makers = {"honda", "acura", "toyota", "landRover", "jaguar", "audi"};
        for (int i = 0; i < makers.length; i++) {
            priceMap.put(makers[i], (i + 1) * 10000);
        }

        for (String s : makers) {
            showEncodedOutput(makers, s);
        }
    }
}
