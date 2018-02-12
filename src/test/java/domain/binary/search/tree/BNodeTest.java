package src.test.java.domain.binary.search.tree;

import domain.binary.search.tree.BNode;
import junit.framework.TestCase;
import org.junit.Test;

public class BNodeTest extends TestCase {
    private BNode bNode = null;

    @Test
    public void testBNode() {
        bNode = new BNode(5);

        assertTrue(bNode.getData() == 5);
        assertTrue(bNode.getLeft() == null);
        assertTrue(bNode.getRight() == null);
    }
}
