package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockString {

    static String isValid(String s) {
        char[]                stringChars    = s.toCharArray();
        Map<String, Integer>  charFreq       = buildFreqMap(stringChars);
        int                   minFreq        = findMinFreq(charFreq);
        Map<Integer, Integer> derivedFreqMap = buildDerivedFreqMap(charFreq);
        String                valid          = "YES";

        if (derivedFreqMap.keySet().size() == 1) {
            return valid;
        } else if (derivedFreqMap.keySet().size() > 2) {
            return "NO";
        } else if (minFreq == 1) {
            return valid;
        } else {
            int diff;
            for (Integer freq : derivedFreqMap.keySet()) {
                if (freq != minFreq) {
                    diff = Math.abs(freq - minFreq);
                    if (diff == 1) {
                        return "YES";
                    } else {
                        return "NO";
                    }
                }
            }
            return "NO";
        }
    }

    static Map<String, Integer> buildFreqMap(char[] stringChars) {
        Map<String, Integer> charFreq = new HashMap<>();
        for (char c : stringChars) {
            String cString = makeString(c);
            if (charFreq.containsKey(cString)) {
                int freq = charFreq.get(cString);
                freq++;
                charFreq.put(cString, freq);
            } else {
                charFreq.put(cString, 1);
            }
        }
        return charFreq;
    }

    static Map<Integer, Integer> buildDerivedFreqMap(Map<String, Integer> charFreqMap) {
        Map<Integer, Integer> derivedFreqMap = new HashMap<>();
        for (Integer frequency : charFreqMap.values()) {
            if (derivedFreqMap.containsKey(frequency)) {
                int freq = derivedFreqMap.get(frequency);
                derivedFreqMap.put(frequency, ++freq);
            } else {
                derivedFreqMap.put(frequency, 1);
            }
        }
        return derivedFreqMap;
    }

    static int findMinFreq(Map<String, Integer> charFreqMap) {
        int minFreq = Integer.MAX_VALUE;
        for (String s : charFreqMap.keySet()) {
            int freq = charFreqMap.get(s);
            if (freq < minFreq) {
                minFreq = freq;
            }
        }
        return minFreq;
    }

    static String makeString(char c) {
        return "" + c;
    }

    public static void main(String[] args) {
        Scanner in     = new Scanner(System.in);
        String  s      = in.next();
        String  result = isValid(s);
        System.out.println(result);
    }
}