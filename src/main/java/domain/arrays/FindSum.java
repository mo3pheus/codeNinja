package domain.arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindSum {

    static boolean isSumPresent(int[] integers, int sum) {
        boolean      present = false;
        Set<Integer> diffSet = new HashSet<>();

        for (int i : integers) {
            int diff = sum - i;

            if (diffSet.contains(i)) {
                return true;
            } else {
                diffSet.add(diff);
            }
        }

        return present;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the arraySum problem");

        Scanner  scanner       = new Scanner(System.in);
        int      sum           = Integer.parseInt(scanner.nextLine());
        String[] arrayContents = (scanner.nextLine()).split(" ");
        int[]    integers      = new int[arrayContents.length];
        for (int i = 0; i < arrayContents.length; i++) {
            integers[i] = Integer.parseInt(arrayContents[i]);
        }

        System.out.println(isSumPresent(integers, sum));
    }
}
