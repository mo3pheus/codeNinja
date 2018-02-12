package domain.binary.search.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearchTree implements IsABST {
    Logger logger = LoggerFactory.getLogger(BinarySearchTree.class);
    BNode root;

    @Override
    public BNode find(Integer data) {
        return find(data, root);
    }

    private BNode find(Integer data, BNode node) {
        if (node == null || node.getData() == data) {
            return node;
        } else if (data > node.getData()) {
            return find(data, node.getRight());
        } else {
            return find(data, node.getLeft());
        }
    }

    @Override
    public BNode deleteNode(Integer data) {
        logger.info("Trying to delete node = " + data);
        return null;
    }

    private BNode deleteNode(Integer data, BNode node) {
        return null;
    }

    @Override
    public BNode findLeftMost(BNode node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return findLeftMost(node.getLeft());
        }
    }

    @Override
    public void add(Integer data) {
        logger.info("Adding new element = " + data);
        if (root == null) {
            root = new BNode(data);
        } else {
            add(root, data);
        }
    }

    private void add(BNode tempRoot, Integer data) {
        if (data > tempRoot.getData()) {
            if (tempRoot.getRight() == null) {
                tempRoot.setRight(new BNode(data));
            } else {
                add(tempRoot.getRight(), data);
            }
        } else {
            if (tempRoot.getLeft() == null) {
                tempRoot.setLeft(new BNode(data));
            } else {
                add(tempRoot.getLeft(), data);
            }
        }
    }

    public BNode getRoot() {
        return root;
    }

    public void setRoot(BNode root) {
        this.root = root;
    }

    public BinarySearchTree() {
        root = null;
    }
}
