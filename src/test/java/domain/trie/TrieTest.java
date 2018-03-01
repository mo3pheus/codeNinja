package src.test.java.domain.trie;

import domain.tries.Trie;
import junit.framework.TestCase;

public class TrieTest extends TestCase {
    private              Trie     trie       = new Trie();
    private static final String[] DICTIONARY = {"Hello", "Helium", "World", "I", "Need", "a", "chance", "to", "see",
                                                "your", "yourself", "face", "friend"
    };

    @Override
    public void setUp() {
        System.out.println("===========================================");
        System.out.println("Running Trie Test");
        System.out.println("===========================================");
        for (String word : DICTIONARY) {
            System.out.println(word);
            trie.add(word);
        }
        System.out.println("===========================================");
    }

    public void testPresentWords() {
        for (String word : DICTIONARY) {
            assertTrue(trie.search(word));
        }
    }
}
