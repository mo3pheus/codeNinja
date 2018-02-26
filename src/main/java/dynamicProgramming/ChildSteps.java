package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Count the number of ways a child can jump N steps. The child has the option to jump 1, 2, or 3 steps at a time.
 */
public class ChildSteps {
    static int hits = 0;

    public static int countWaysDP(int n, Map<Integer, Integer> resultMap) {
        if (resultMap.containsKey(n)) {
            hits++;
            return resultMap.get(n);
        } else if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            int result = countWaysDP(n - 3, resultMap)
                    + countWaysDP(n - 2, resultMap)
                    + countWaysDP(n - 1, resultMap);
            resultMap.put(n, result);
            return resultMap.get(n);
        }
    }

    public static int countWaysRecursive(int n) {
        hits++;
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
        }
    }

    public static void main(String[] args) {
        System.out.println("Child step climbing dp demo");
        System.out.println("Count ways ans for recursion algorithm for 10 steps = " + countWaysRecursive(10));
        System.out.println(hits);
        hits = 0;
        System.out.println("Count ways ans for dp algorithm for 10 steps = " + countWaysDP(10, new HashMap<>()));
        System.out.println(hits);
    }
}
