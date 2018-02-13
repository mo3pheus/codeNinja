package domain.binary.search.tree;

public class BNode {
    Integer data;
    BNode   right;
    BNode   left;
    BNode   parent;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public BNode getRight() {
        return right;
    }

    public void setRight(BNode right) {
        this.right = right;
        this.right.setParent(this);
    }

    public BNode getLeft() {
        return left;
    }

    public void setLeft(BNode left) {
        this.left = left;
        this.left.setParent(this);
    }

    public BNode(Integer data) {
        this.data = data;
        this.right = null;
        this.left = null;
        this.parent = null;
    }

    public boolean isLeafNode() {
        return right == null && left == null;
    }

    public BNode getParent() {
        return parent;
    }

    public void setParent(BNode parent) {
        this.parent = parent;
    }
}
