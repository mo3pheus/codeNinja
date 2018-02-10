package domain.linkedList;

public class LinkedList<T> implements IsALinkedList<T> {
    private lNode<T> head;

    @Override
    public void add(Object data) {
        if (head == null) {
            head = new lNode(data);
        } else {
            lNode tail = findTail();
            lNode temp = new lNode(data);
            tail.setNext(temp);
        }
    }

    public lNode<T> getHead() {
        return head;
    }

    @Override
    public lNode getTail() {
        return findTail();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(T data) {

        lNode temp = head;
        while (temp != null) {
            if (temp.getData().equals(data)) {
                return true;
            } else {
                temp = temp.getNext();
            }
        }

        return false;
    }

    @Override
    public T delete(T data) {
        if (!contains(data)) {
            return null;
        }

        if (head.getData().equals(data)) {
            if (head.getNext() != null) {
                lNode temp = head;
                head = head.getNext();
            } else {
                head = null;
            }
            return data;
        }

        lNode target = find(data);

        lNode parent = head;
        while (parent.getNext() != target) {
            parent = parent.getNext();
        }

        if (target.getNext() == null) {
            parent.setNext(null);
        } else {
            parent.setNext(target.getNext());
        }
        return data;
    }

    @Override
    public String getContents() {
        lNode         temp    = head;
        StringBuilder content = new StringBuilder();
        while (temp != null) {
            content.append(temp.toString());
            temp = temp.getNext();
        }

        return content.toString();
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public lNode find(T data) {
        lNode temp = head;

        while (temp != null) {
            if (temp.getData().equals(data)) {
                return temp;
            } else {
                temp = temp.getNext();
            }
        }
        return null;
    }

    public LinkedList() {
        head = null;
    }

    private lNode findTail() {
        lNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp;
    }
}
