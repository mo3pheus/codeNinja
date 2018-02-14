package domain.linkedList;

public interface IsALinkedList<T> {

    void add(T data);

    lNode getHead();

    lNode getTail();

    boolean isEmpty();

    boolean contains(T data);

    T delete(T data);

    String getContents();

    void clear();

    lNode find(T data);

    void insertAtPosition(T data, int position);
}
