package domain.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Character data;
    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean leaf;

    public TrieNode() {
    }

    public TrieNode(Character c) {
        this.data = c;
        leaf = (children.isEmpty());
    }

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
