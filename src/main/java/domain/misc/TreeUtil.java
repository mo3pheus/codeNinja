package domain.misc;

import domain.binary.search.tree.BNode;

public class TreeUtil {

    public static void printInorder(BNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.getLeft());
        System.out.print(root.getData() + " ");
        printInorder(root.getRight());
    }

    public static void printPreOrder(BNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }

    public static void printPostOrder(BNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.getLeft());
        printPostOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }
}
