package strings;

import domain.linkedList.LinkedList;
import domain.linkedList.lNode;

import java.util.HashMap;
import java.util.Map;

public class CrackPasswords {
    static Map<String, LinkedList<String>> passwordMap = new HashMap<>();

    static String convertCharToString(char c) {
        return (new StringBuilder()).append(c).toString();
    }

    static void setUpPasswordMap(String[] passwords) {
        String rootNodes = "abcdefghijklmnopqrstuvwxyz";

        for (char c : rootNodes.toCharArray()) {
            String             cString = convertCharToString(c);
            LinkedList<String> temp    = new LinkedList<>();
            passwordMap.put(cString, temp);
        }

        for (String s : passwords) {
            char[] temp       = s.toCharArray();
            String rootString = convertCharToString(temp[0]);
            for (int i = 0; i < temp.length; i++) {
                // flag the last character/ end of a password.
                lNode<String> tempNode = new lNode<>(convertCharToString(temp[i]));
                if (i == temp.length - 1) {
                    tempNode.setFlag(true);
                }
                passwordMap.get(rootString).add(tempNode);
            }
        }
    }

    static boolean isValidPassword(String[] loginAttempt, int index, lNode password) {
        // last char
        if (index == (loginAttempt.length - 1) && password.isFlag() && loginAttempt[index].equals(password.getData())) {
            return true;
        } else {
            return false;
        }


        // else continue evaluating password
        // handle end of password to switch to new root 
    }


    public static void main(String[] args) {
        System.out.println("Welcome to crack passwords.");
    }
}
