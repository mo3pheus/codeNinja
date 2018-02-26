package domain.stacks;

import java.util.Stack;

public class MatchingBrackets {
    static String isBalanced(String s) {
        Stack<String> brackets = new Stack<>();
        char[]        input    = s.toCharArray();
        for (char c : input) {
            if (!brackets.empty() && matches(brackets.peek(), c)) {
                brackets.pop();
            } else {
                brackets.push(charToString(c));
            }
        }

        if (brackets.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    static String charToString(char c) {
        return (new StringBuilder()).append(c).toString();
    }

    static boolean matches(String aString, char b) {
        char a = aString.toCharArray()[0];

        if ((a == '{' && b == '}')
                || (a == '(' && b == ')')
                || (a == '[' && b == ']')
                || (b == '{' && a == '}')
                || (b == '(' && a == ')')
                || (b == '[' && a == ']')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s      = "{(}";
        String result = isBalanced(s);
        System.out.println(result);
    }
}
