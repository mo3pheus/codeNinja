package domain.binary.search.tree;

public interface IsABST {
    BNode find(Integer data);

    BNode deleteNode(Integer data);

    BNode findLeftMost(BNode node);

    void add(Integer data);
}
