package domain.stacks;

import java.util.Scanner;
import java.util.Stack;

public class LongestIncreasingSubsequence {
    static Stack<Integer> lis = new Stack();

    static int getLongestIncreasingSubsequence(int[] integers) {
        for (int i = 1; i < integers.length; i++) {
            if (integers[i] > lis.peek()) {
                lis.add(integers[i]);
            }
        }
        return lis.size();
    }

    public static void main(String[] args) {
        Scanner  scanner  = new Scanner(System.in);
        String[] input    = (scanner.nextLine()).split(" ");
        int[]    integers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            integers[i] = Integer.parseInt(input[i]);
        }

        lis.add(integers[0]);
        System.out.println(getLongestIncreasingSubsequence(integers));
    }
}
