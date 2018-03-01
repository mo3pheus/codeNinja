package domain.tries;

import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String s) {
        TrieNode                 current  = root;
        Map<Character, TrieNode> children = current.getChildren();
        for (int i = 0; i < s.length(); i++) {
            if (children.containsKey(s.charAt(i))) {
                current = children.get(s.charAt(i));
                children = current.getChildren();
            } else {
                TrieNode temp = new TrieNode(s.charAt(i));
                if (i == s.length() - 1) {
                    temp.setLeaf(true);
                }
                children.put(s.charAt(i), temp);
                children = temp.getChildren();
            }
        }
    }

    public boolean search(String word) {
        TrieNode                 current  = root;
        Map<Character, TrieNode> children = current.getChildren();
        for (int i = 0; i < word.length(); i++) {
            if (children.containsKey(word.charAt(i))) {
                current = children.get(word.charAt(i));
                children = current.getChildren();
                if ((i == word.length() - 1) && current.isLeaf()) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
