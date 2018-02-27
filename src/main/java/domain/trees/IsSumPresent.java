package domain.trees;

import domain.binary.search.tree.BNode;
import domain.misc.TreeUtil;

public class IsSumPresent {
    public static void main(String[] args) {
        System.out.println("This checks if a sum is present in the binary tree");
        BNode[] tree = new BNode[7];
        tree[0] = new BNode(10);
        tree[1] = new BNode(30);
        tree[2] = new BNode(-10);
        tree[3] = new BNode(20);
        tree[4] = new BNode(5);
        tree[5] = new BNode(8);
        tree[6] = new BNode(40);

        tree[0].setRight(tree[4]);
        tree[0].setLeft(tree[1]);
        tree[1].setLeft(tree[2]);
        tree[1].setRight(tree[3]);
        tree[4].setLeft(tree[5]);
        tree[4].setRight(tree[6]);

        TreeUtil.printInorder(tree[0]);
        System.out.println(isSumPresent(tree[0], 30));
    }

    public static boolean isSumPresent(BNode root, int sum) {
        if (root == null) {
            return (sum == 0);
        }

        if (root.isLeafNode()) {
            return ((sum - root.getData()) == 0);
        } else {
            return isSumPresent(root.getLeft(), sum - root.getData()) || isSumPresent(root.getRight(), sum - root
                    .getData());
        }
    }
}
