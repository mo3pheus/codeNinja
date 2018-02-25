package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChangeMaker {
    static final Integer[] COINS = {1, 5, 10, 20, 25};

    static int makeChangeGreedy(int sum) {
        List<Integer> coins = new ArrayList<>();
        coins.addAll(Arrays.asList(COINS));
        Collections.sort(coins);
        Collections.reverse(coins);

        int numCoins    = 0;
        int requiredSum = sum;
        int i           = 0;
        while (requiredSum > 0) {
            if (requiredSum < coins.get(coins.size() - 1)) {
                // no solution found.
                return -1;
            } else if (requiredSum < coins.get(i)) {
                i++;
            } else {
                numCoins += (requiredSum / coins.get(i));
                requiredSum = requiredSum % coins.get(i);
                i++;
            }
        }

        return numCoins;
    }

    public static void main(String[] args) {
        int sum = 40;

        System.out.println(makeChangeGreedy(sum));
    }
}
