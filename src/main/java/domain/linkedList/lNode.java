package domain.linkedList;

public class lNode<T> {
    T       data;
    lNode   next;
    boolean flag;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public lNode getNext() {
        return next;
    }

    public void setNext(lNode next) {
        this.next = next;
    }

    public lNode(T data) {
        this.data = data;
        this.next = null;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String toString() {
        return " data = " + data;
    }
}
