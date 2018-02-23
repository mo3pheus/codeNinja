package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbers {
    static Map<Integer, Long> fibNumbersMap = new HashMap<>();

    static long findFibonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        long result = 0l;
        if (fibNumbersMap.containsKey(n)) {
            System.out.println(" Hit on n = " + n);
            return fibNumbersMap.get(n);
        } else {
            result = findFibonacci(n - 1) + findFibonacci(n - 2);
            fibNumbersMap.put(n, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to FibonacciNumbers - the DP approach.");
        Double sum = 0.0d;
        for (int i = 90; i >= 0; i--) {
            long result = findFibonacci(i);
            sum += result;
            System.out.println(result);
        }

        System.out.println(" Sum of the first 99 = " + sum);
    }
}
