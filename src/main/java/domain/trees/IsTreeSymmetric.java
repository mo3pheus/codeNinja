package domain.trees;

import domain.binary.search.tree.BNode;
import domain.misc.TreeUtil;

public class IsTreeSymmetric {
    public static boolean isTreeSymmetric(BNode a, BNode b) {
        if (a == null && b == null) {
            return true;
        } else {
            return (a.getData() == b.getData())
                    && (isTreeSymmetric(a.getRight(), b.getLeft()))
                    && (isTreeSymmetric(a.getLeft(), b.getRight()));
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to isTreeSymmetric. ");
        String algorithm = "1. always have two trees to check" +
                " 2. leftNode of rightTree == rightNode of leftTree" +
                " 3. rightNode of leftTree == leftNode of rightTree " +
                " 4. first call is made using root, root";

        BNode[] tree = new BNode[7];
        tree[0] = new BNode(10);
        tree[1] = new BNode(-1);
        tree[2] = new BNode(2);
        tree[3] = new BNode(48);
        tree[4] = new BNode(-1);
        tree[5] = new BNode(48);
        tree[6] = new BNode(2);

        tree[0].setRight(tree[4]);
        tree[0].setLeft(tree[1]);
        tree[1].setLeft(tree[2]);
        tree[1].setRight(tree[3]);
        tree[4].setLeft(tree[5]);
        tree[4].setRight(tree[6]);

        TreeUtil.printInorder(tree[0]);
        System.out.println(isTreeSymmetric(tree[0], tree[0]));
    }
}
