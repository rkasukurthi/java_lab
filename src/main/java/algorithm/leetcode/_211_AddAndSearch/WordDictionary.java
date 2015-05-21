package algorithm.leetcode._211_AddAndSearch;

import static org.junit.Assert.*;

import org.junit.Test;

class TrieNode {
    TrieNode[] children=new TrieNode[26];
    boolean isWord=false;
    char c;
    
    protected TrieNode setNode(char c) {
	int i = c - 'a';
	if (children[i] == null) {
	    children[i] = new TrieNode();
	    children[i].c=c;
	}
	return children[i];
    }
    
    protected TrieNode getNode(char c) {
	return children[c - 'a'];
    }
}

public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
	root = new TrieNode();
    }
    
    // Inserts a word into the trie.
    public void addWord(String word) {
	TrieNode lastNode = root;
	for (int i = 0; i < word.length(); i++) {
	    lastNode = lastNode.setNode(word.charAt(i));
	}
	lastNode.isWord = true;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
	return search(0, word, root);
    }
    
    // Returns if the word is in the trie.
    private boolean search(int i, String word, TrieNode lastNode) {
	if (lastNode == null)  return false;
	
	if (i == charArr.length){
	    return lastNode.isWord;
	}
	
	if (charArr[i] == '.') {
	    for (TrieNode node : lastNode.children) {
		if (search(i+1, charArr, node)) return true;
	    }
	} else {
	    lastNode = lastNode.getNode(charArr[i]);
	    return search(i+1, charArr, lastNode);
	}
	return false;
    }
    
    @Test
    public void testTrie() {
	WordDictionary trie = new WordDictionary();
	trie.addWord("bad");
	trie.addWord("mad");
	assertFalse(trie.search("pad"));
	assertTrue(trie.search("bad"));
	assertTrue(trie.search(".ad"));
	assertTrue(trie.search("b.."));
    }
}
