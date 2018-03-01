package domain.trees;

/**
 * This code passed all test cases on hackerRank.
 */
public class BSTValidation {
    public static void main(String[] args) {

    }

    static boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

    static int getMin(Node root) {
        if (isLeaf(root)) {
            return root.data;
        } else if (root.right != null && root.left != null) {
            return Math.min(root.data, Math.min(getMin(root.right), getMin(root.left)));
        } else if (root.right != null) {
            return Math.min(root.data, getMin(root.right));
        } else {
            return Math.min(root.data, getMin(root.left));
        }
    }

    static int getMax(Node root) {
        if (isLeaf(root)) {
            return root.data;
        } else if (root.right != null && root.left != null) {
            return Math.max(root.data, Math.max(getMax(root.right), getMax(root.left)));
        } else if (root.right != null) {
            return Math.max(root.data, getMax(root.right));
        } else {
            return Math.max(root.data, getMax(root.left));
        }
    }

    static boolean checkBST(Node root) {
        if (root == null || isLeaf(root)) {
            return true;
        }

        if (root.left != null && root.right != null) {
            if (root.data > getMax(root.left) && root.data < getMin(root.right)) {
                return ((checkBST(root.left)) && (checkBST(root.right)));
            } else {
                return false;
            }
        } else if (root.right != null && root.data < getMin(root.right)) {
            return checkBST(root.right);
        } else if (root.left != null && root.data > getMax(root.left)) {
            return checkBST(root.left);
        }
        return false;
    }

    static class Node {
        int  data;
        Node right;
        Node left;

        Node(int x) {
            data = x;
            right = null;
            left = null;
        }
    }
}
