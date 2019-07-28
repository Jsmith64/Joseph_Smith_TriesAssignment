
import java.util.Set;

public class Trie {
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    
    public boolean isPrefixValid(String prefix) {
    	// gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < prefix.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = prefix.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                return false;
            }
            currentNode = child;
        }
        
        return true;
    }
    
    public boolean isWordValid(String word) {
    	// gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                return false;
            }
            currentNode = child;
        }
        
        return currentNode.isCompleteWord;
    }
    
    public void printAllKeys() {
    	Set<Character> keys = this.root.children.keySet();
    	Node currentNode = this.root;
        for(Character key : keys) {
        	Node child = currentNode.children.get(key);
        	if(child != null) {
        		Trie.printHelper(child);
        	}
        	System.out.println(key);
        }
  
     }
    
    private static void printHelper(Node current) {
    	Set<Character> keys = current.children.keySet();
    	for(Character key : keys) {
        	Node child = current.children.get(key);
        	if(child != null) {
        		Node temp = child;
        		Trie.printHelper(temp);
        	}
        	System.out.println(key);	
        }
    }
}
