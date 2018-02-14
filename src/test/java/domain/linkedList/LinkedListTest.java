package src.test.java.domain.linkedList;

import domain.linkedList.IsALinkedList;
import domain.linkedList.LinkedList;
import domain.linkedList.lNode;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LinkedListTest extends TestCase {

    IsALinkedList<Double> linkedList = null;

    @Before
    public void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        int[] temp = {4, 5, 6, 7};
        for (int i : temp) {
            linkedList.add(new Double(i));
        }

        for (int i : temp) {
            assertTrue(linkedList.contains(new Double(i)));
        }

        System.out.println(linkedList.getContents());
    }


    @Test
    public void testContains() {
        setUpLinkedList();

        int[] temp = {4, 5, 6, 7};

        for (int i : temp) {
            assertTrue(linkedList.contains(new Double(i)));
        }

        assertFalse(linkedList.contains(new Double(-10.0d)));
    }


    @Test
    public void testDelete() {
        setUpLinkedList();
        int[] temp = {4, 5, 6, 7};
        for (int i : temp) {
            linkedList.delete(new Double(i));
        }

        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testClear() {
        setUpLinkedList();
        System.out.println(linkedList.toString());
        assertTrue(linkedList.toString().equals("4.0 5.0 6.0 7.0 "));
        linkedList.clear();
        assertTrue(linkedList.toString() == null);
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testCyclicLinkedList() {
        setUpCyclicLinkedList();
        assertTrue(isCyclic(linkedList));

        linkedList.clear();
        setUpLinkedList();
        assertFalse(isCyclic(linkedList));
    }

    @Test
    public void testInsertAtPosition() {
        setUpLinkedList();
        assertTrue(linkedList.toString().equals("4.0 5.0 6.0 7.0 "));
        linkedList.insertAtPosition(5.0, 0);
        assertTrue(linkedList.toString().equals("5.0 4.0 5.0 6.0 7.0 "));
        linkedList.insertAtPosition(-2.0, 2);
        assertTrue(linkedList.toString().equals("5.0 4.0 -2.0 5.0 6.0 7.0 "));

        try {
            linkedList.insertAtPosition(-3.0, 100);
        } catch (NullPointerException n) {
            assertTrue(linkedList.toString().equals("5.0 4.0 -2.0 5.0 6.0 7.0 "));
        }
    }

    private boolean isCyclic(IsALinkedList linkedList) {
        lNode      temp         = linkedList.getHead();
        Set<lNode> visitedNodes = new HashSet<>();
        while (temp != null) {
            if (visitedNodes.contains(temp)) {
                return true;
            } else {
                visitedNodes.add(temp);
                temp = temp.getNext();
            }
        }
        return false;
    }

    private void setUpCyclicLinkedList() {
        linkedList.clear();
        linkedList.add(1.0d);
        linkedList.add(2.0d);
        linkedList.add(3.0d);
        linkedList.add(4.0d);

        lNode tail = linkedList.getTail();
        tail.setNext(linkedList.getHead());
    }

    private void setUpLinkedList() {
        int[] temp = {4, 5, 6, 7};

        for (int i : temp) {
            linkedList.add(new Double(i));
        }
    }
}
