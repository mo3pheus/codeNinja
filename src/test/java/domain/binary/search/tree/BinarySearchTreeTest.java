package src.test.java.domain.binary.search.tree;

import domain.binary.search.tree.BinarySearchTree;
import junit.framework.TestCase;
import org.junit.Test;

public class BinarySearchTreeTest extends TestCase {
    private BinarySearchTree binarySearchTree = null;

    @Override
    public void setUp() {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void testCreation() {
        assertTrue(binarySearchTree.getRoot() == null);
    }

    @Test
    public void testInsertion() {
        int[] Elements = {10, 20, 30, 12, 13, 14, 16, 33, 44, 55, 7, 8, 5, 42};

        for (int i : Elements) {
            binarySearchTree.add(i);
        }

        for (int i : Elements) {
            assertTrue(binarySearchTree.find(i).getData() == i);
        }
    }

}
