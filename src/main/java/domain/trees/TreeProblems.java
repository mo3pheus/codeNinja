package domain.trees;

import domain.binary.search.tree.BNode;
import domain.binary.search.tree.BinarySearchTree;

public class TreeProblems {
    private static BinarySearchTree binarySearchTree = null;

    private static boolean isBST(BinarySearchTree binarySearchTree) {
        return isBST(binarySearchTree.getRoot());
    }

    private static boolean isBST(BNode root) {
        if (root == null) {
            return true;
        }

        if (root.getLeft() != null && root.getLeft().getData() > root.getData()) {
            return false;
        }

        if (root.getRight() != null && root.getRight().getData() < root.getData()) {
            return false;
        }

        if (!isBST(root.getRight()) || !isBST(root.getLeft())) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        binarySearchTree = new BinarySearchTree();
        int[] elements = {4, 10, 50, 2, -10, -40, -13, 22, 34, 55, 66};

        for (int i : elements) {
            binarySearchTree.add(i);
        }

        binarySearchTree.printInOrder();
        System.out.println("======================================================");
        binarySearchTree.printPreOrder();
        System.out.println("======================================================");
        binarySearchTree.printPostOrder();
        System.out.println("======================================================");
        System.out.println(isBST(binarySearchTree));
    }
}
