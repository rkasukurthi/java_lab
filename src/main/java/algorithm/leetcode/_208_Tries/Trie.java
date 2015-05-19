package algorithm.leetcode._208_Tries;

import static org.junit.Assert.*;

import org.junit.Test;

class TrieNode {
    // Initialize your data structure here.
    public TrieNode() {
	boolean isLeaf;
	boolean isWord;
	char v;
	
    }
}

public class Trie {
    private TrieNode root;
    
    public Trie() {
	root = new TrieNode();
    }
    
    // Inserts a word into the trie.
    public void insert(String word) {
	
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
	return false;
	
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
	return false;
	
    }
    
    @Test
    public void testTrie() {
	
	Trie trie = new Trie();
	trie.insert("somestring");
	trie.insert("question");
	assertTrue(trie.search("somestring"));
	assertFalse(trie.search("key"));
	assertTrue(trie.startsWith("quest"));
	assertFalse(trie.startsWith("quested"));
     }
    
}

