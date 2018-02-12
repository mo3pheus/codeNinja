package domain.binary.search.tree;

public class BNode {
    Integer data;
    BNode   right;
    BNode   left;

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
    }

    public BNode getLeft() {
        return left;
    }

    public void setLeft(BNode left) {
        this.left = left;
    }

    public BNode(Integer data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public boolean isLeafNode() {
        return right == null && left == null;
    }
}
