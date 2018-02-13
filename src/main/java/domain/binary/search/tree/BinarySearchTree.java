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
        return deleteNode(data, root);
    }

    private BNode deleteNode(Integer data, BNode node) {
        if (node == null) {
            logger.error("Data " + data + " not present in tree.");
            return null;
        } else if (root.getData() == data) {
            BNode temp = new BNode(data);
            temp.setRight(root.getRight());
            temp.setLeft(root.getLeft());

            if (root.isLeafNode()) {
                root = null;
            } else if (root.getRight() != null && root.getLeft() != null) {
                Integer tempVal = findLeftMost(root.getRight()).getData();
                deleteNode(tempVal, root.getRight());
                root.setData(tempVal);
            } else if (root.getLeft() == null) {
                root = root.getRight();
            } else {
                root = root.getLeft();
            }

            return temp;
        }

        if (node.getData() == data) {
            BNode parent = node.getParent();
            if (node.isLeafNode()) {
                deleteChild(parent, data);
                return node;
            } else if (node.getRight() != null && node.getLeft() != null) {
                BNode replacementNode = findLeftMost(node.getRight());
                node.setData(replacementNode.getData());
                return deleteNode(data, node.getRight());
            } else if (node.getRight() != null) {
                if (node.getRight().getData() > parent.getData()) {
                    parent.setRight(node.getRight());
                } else {
                    parent.setLeft(node.getLeft());
                }
                return node;
            } else if (node.getLeft() != null) {
                parent.setLeft(node.getLeft());
                return node;
            }
        } else if (data < node.getData()) {
            return deleteNode(data, node.getLeft());
        } else {
            return deleteNode(data, node.getRight());
        }

        return null;
    }

    private void deleteChild(BNode node, Integer data) {
        if (node.getRight().getData() == data) {
            node.setRight(null);
        } else if (node.getLeft().getData() == data) {
            node.setLeft(null);
        }
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
