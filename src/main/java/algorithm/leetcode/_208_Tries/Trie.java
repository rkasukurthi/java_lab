package algorithm.leetcode._208_Tries;

import static org.junit.Assert.*;

import org.junit.Test;

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    char c;
    
    public TrieNode() {
      children = new TrieNode[26];
      isWord=false;
    }
    
    public TrieNode(char c){
	this();
	this.c=c;
    }
    
    protected TrieNode setNode(char c){
	int i= c-'a';
	if (children[i]==null){
	    children[i]= new TrieNode(c);
	}
	return children[i];
    }
    
    protected TrieNode getNode(char c){
	return children[c -'a'];
    }
}

public class Trie {
    private TrieNode root;
    
    public Trie() {
	root = new TrieNode();
    }
    
    // Inserts a word into the trie.
    public void insert(String word) {
	TrieNode lastNode = root;
	for(int i=0; i<word.length(); i++){
	    lastNode=lastNode.setNode(word.charAt(i));
	}
	lastNode.isWord=true;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
	TrieNode lastNode =getLastNode(word);
	return (lastNode ==null)? false:lastNode.isWord;
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
	return (getLastNode(prefix) ==null)? false:true;
    }
    
    private TrieNode getLastNode(String word){
	TrieNode lastNode = root;
	for(int i=0; i<word.length(); i++){
	    lastNode=lastNode.getNode(word.charAt(i));
	    if (lastNode==null) return null;
	}
	return lastNode;
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
