package domain.stacks;

import java.util.Scanner;
import java.util.Stack;

public class TowerHeights {
    public static int findPops(int[] a, int[] b, int[] c) {
        Stack aStack = makeStack(a);
        Stack bStack = makeStack(b);
        Stack cStack = makeStack(c);

        int numPops = 0;
        while (!aStack.empty() && !bStack.empty() && !cStack.empty()
                && (getHeight(aStack) != getHeight(bStack)) && (getHeight(cStack) != getHeight(aStack))) {

        }
        return numPops;
    }

    public static Stack<Integer> makeStack(int[] a) {
        Stack s = new Stack();
        for (int i : a) {
            s.push(i);
        }
        return s;
    }

    public static int getHeight(Stack<Integer> z) {
        int   sum  = 0;
        Stack temp = new Stack();
        temp.addAll(z);
        while (!temp.empty()) {
            sum += (Integer) temp.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in   = new Scanner(System.in);
        int     n1   = in.nextInt();
        int     n2   = in.nextInt();
        int     n3   = in.nextInt();
        int     h1[] = new int[n1];
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
        }
    }
}
