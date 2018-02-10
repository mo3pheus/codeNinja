package src.test.java.domain.linkedList;

import domain.linkedList.lNode;
import junit.framework.TestCase;
import org.junit.Test;

public class lNodeTest extends TestCase {
    private lNode firstNode  = null;
    private lNode secondNode = null;

    @Override
    public void setUp() {
        System.out.println("Hello World");
        firstNode = new lNode("Hello");
        secondNode = new lNode("World");
    }

    @Test
    public void test1() {
        System.out.println("lNode test");
        firstNode.setNext(secondNode);
        System.out.println(firstNode.toString());
        System.out.println(secondNode.toString());
    }
}