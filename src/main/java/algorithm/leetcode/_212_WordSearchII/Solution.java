package algorithm.leetcode._212_WordSearchII;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [ ['o','a','a','n'], 
 *   ['e','t','a','e'], 
 *   ['i','h','k','r'], 
 *   ['i','f','l','v'] 
 * ] 
 * Return ["eat","oath"].
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * 
 * Thought: Using Trie as word dictionary, search array as find isolated island.
 * 
 * 
 * @author zluo
 * 
 */
public class Solution {
  class TrieNode {
    TrieNode[] children;
    TrieNode parent;
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
        children[i].parent=this;
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
  }
  List<String> result= new ArrayList<String>();
  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = buildDictionary(words);
    TrieNode root=trie.root;
    for (int i=0; i<board.length;i++) {
      for(int j=0; j<board[0].length; j++) {
        find(i,j, root, board,new int[board.length][board[0].length]);
      }
    }
    return result;
  }
  
  void find(int i, int j, TrieNode parent, char[][] board, int[][] history) {
    if (i<0 || j<0 || i>=history.length ||j>=history[0].length || history[i][j]==1) return;
    TrieNode node =parent.getNode(board[i][j]);
    if (node==null) return;
    history[i][j]=1;
    if (node.isWord) {
      addResult(node);
    }
    find(i-1,j,node,board,history);
    find(i+1,j,node,board,history);
    find(i,j-1,node,board,history);
    find(i,j+1,node,board,history);
    history[i][j]=0;
  }
  
  void addResult(TrieNode node) {
    node.isWord=false;
    String s="";
    while(node.parent !=null) {
      s=node.c+s;
      node=node.parent;
    }
    result.add(s);
  }
  
  
  Trie buildDictionary(String[] words) {
    Trie trie = new Trie();
    for(String word: words) {
      trie.insert(word);
    }
    return trie;
  }
  @Test
  public void test1() {
    assertEquals(2, findWords(new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}}, new String[] {"eat","oath","pea","rain"}).size());
  }
  @Test
  public void test2() {
    assertEquals(1, findWords(new char[][] {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}}, new String[] {"aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaab"}).size());
  }
  @Test
  public void test3() {
    assertEquals(1, findWords(new char[][] {{'a','a'}}, new String[] {"a"}).size());
  }
  @Test
  public void test4() {
    assertEquals(1, findWords(new char[][] {{'a','b'},{'c','d'}}, new String[] {"cdba"}).size());
  }
/*  @Test
  public void test5() {
      
      String[] input ={"baabab","abaaaa","abaaab","ababba","aabbab","aabbba","aabaab"};
      String[] words ={"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};
      
      assertEquals(1, findWords());
  }*/
}
