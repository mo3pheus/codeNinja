package strings;

import domain.tries.Trie;
import domain.tries.TrieNode;

import java.util.Map;

public class CrackPasswords {
    static Trie passwordMap = new Trie();

    static void setUpPasswordMap(String[] passwords) {
        for (String password : passwords) {
            passwordMap.add(password);
        }
    }

    static void evaluatePasswords(String[] loginAttempts) {
        for (String password : loginAttempts) {
            System.out.println(" Password tried is = " + password);
            System.out.println(" Password validity = " + isValidPassword(password, 0));
        }
    }

    static boolean isValidPassword(String loginAttempt, int index) {
        return isValidPassword(loginAttempt, index, passwordMap.getRoot());
    }

    static boolean isValidPassword(String loginAttempt, int index, TrieNode root) {
        if (root == null || !root.getData().equals(loginAttempt.charAt(index))) {
            return false;
        } else if (root.getData().equals(loginAttempt.charAt(index))) {
            if (root.isLeaf()) {
                if (index == loginAttempt.length() - 1) {
                    return true;
                } else {
                    index++;
                    Map<Character, TrieNode> children = root.getChildren();
                    return (isValidPassword(loginAttempt, index, passwordMap.getRoot()) || isValidPassword
                            (loginAttempt, index, children.get(loginAttempt.charAt(index))));
                }
            } else {
                index++;
                root = root.getChildren().get(loginAttempt.charAt(index));
                return isValidPassword(loginAttempt, index, root);
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to crack passwords.");
    }
}
