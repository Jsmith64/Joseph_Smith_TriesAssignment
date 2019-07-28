import java.util.Set;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("tryfdg");
        
        Set<Character> keys = trie.root.children.keySet();
        for(Character key : keys) {
        	System.out.println(key);
        }
        
        System.out.println(trie.isPrefixValid("trie"));
        System.out.println(trie.isWordValid("trie"));
        trie.printAllKeys();
    }
}