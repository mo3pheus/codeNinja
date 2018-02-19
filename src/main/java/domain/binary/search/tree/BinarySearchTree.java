package domain.binary.search.tree;

public class BinarySearchTree implements IsABST {
    public BNode root = null;

    @Override
    public BNode find(Integer data) {
        if (root == null) {
            return null;
        }

        BNode temp = root;
        while (temp != null && temp.getData() != data) {
            if (data < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return temp;
    }

    @Override
    public BNode deleteNode(Integer data) {
        BNode nodeToDelete = find(data);
        if (nodeToDelete == null) {
            return null;
        }

        if (root.getData() == data) {
            if (isLeaf(root)) {
                root = null;
            } else {
                BNode leftMost = findLeftMost(root.getRight());
                root.setData(leftMost.getData());
                deleteNode(leftMost.getParent(), leftMost.getData());
            }
        } else {
            BNode parent = nodeToDelete.getParent();
            deleteNode(parent, data);
        }
        return nodeToDelete;
    }

    private void deleteNode(BNode parent, Integer data) {
        BNode nodeToDelete = null;
        if (parent.getLeft().getData() == data) {
            nodeToDelete = parent.getLeft();
            if (isLeaf(nodeToDelete)) {
                parent.setLeft(null);
            } else if (nodeToDelete.getLeft() != null && nodeToDelete.getRight() != null) {
                BNode leftMostChild = findLeftMost(nodeToDelete.getRight());
                parent.getLeft().setData(leftMostChild.getData());
                deleteNode(leftMostChild.getParent(), leftMostChild.getData());
            } else if (nodeToDelete.getRight() != null) {
                parent.setLeft(nodeToDelete.getRight());
            } else {
                parent.setLeft(nodeToDelete.getLeft());
            }
        } else {
            nodeToDelete = parent.getRight();
            if (isLeaf(nodeToDelete)) {
                parent.setRight(null);
            } else if (nodeToDelete.getLeft() != null && nodeToDelete.getRight() != null) {
                BNode leftMostChild = findLeftMost(nodeToDelete.getRight());
                parent.getRight().setData(leftMostChild.getData());
                deleteNode(leftMostChild.getParent(), leftMostChild.getData());
            } else if (nodeToDelete.getRight() != null) {
                parent.setRight(nodeToDelete.getRight());
            } else {
                parent.setRight(nodeToDelete.getLeft());
            }
        }
    }

    public boolean isLeaf(BNode node) {
        return node.getLeft() == null && node.getRight() == null;
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
        if (root == null) {
            root = new BNode(data);
        } else {
            add(data, root);
        }
    }

    private void add(Integer data, BNode node) {
        if (data < node.getData()) {
            if (node.getLeft() == null) {
                node.setLeft(new BNode(data));
            } else {
                add(data, node.getLeft());
            }
        } else if (data > node.getData()) {
            if (node.getRight() == null) {
                node.setRight(new BNode(data));
            } else {
                add(data, node.getRight());
            }
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(BNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.getLeft());
        System.out.println(root.getData());
        printInOrder(root.getRight());
    }

    public void printPostOrder() {
        printInOrder(root);
    }

    private void printPostOrder(BNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.getLeft());
        System.out.println(root.getData());
        printPostOrder(root.getRight());
    }


    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(BNode root) {
        if (root == null) {
            return;
        }

        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
        System.out.println(root.getData());
    }

    public BNode getRoot() {
        return root;
    }

    public void setRoot(BNode root) {
        this.root = root;
    }
}