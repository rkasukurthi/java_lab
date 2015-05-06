package algorithm.leetcode._139_WordBreak;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    public boolean wordBreak(String s, Set<String> wordDict) {
	stack.push(0);
	return wordBreak(0,s,wordDict);
    }
    public boolean wordBreak(int i, String s, Set<String> wordDict) {
	if (i==s.length()) return true;
	int e=i;
	while( e<s.length()){
	    String s1=s.substring(i, e+1);
	  if (wordDict.contains(s1)){
	      stack.push(e);
	      wordBreak(++e,s,wordDict);
	  }else{
	      e++;
	  }
	}
	return false;
    }
    
    @Test
    public void test2(){
	Set<String> dict = new HashSet<String>();
	dict.add("leet");
	dict.add("code");
	dict.add("word");
	dict.add("key");
	assertTrue(wordBreak("leet",dict));
    }
    
    @Test
    public void test0(){
	Set<String> dict = new HashSet<String>();
	dict.add("leet");
	dict.add("code");
	dict.add("word");
	dict.add("key");
	assertTrue(wordBreak("leet",dict));
	assertTrue(wordBreak("leetcode",dict));
	assertTrue(wordBreak("leetwordcodekey",dict));
    }
    
    @Test
    public void test1(){
	Set<String> dict = new HashSet<String>();
	dict.add("leet");
	dict.add("code");
	dict.add("word");
	dict.add("key");
	assertTrue(wordBreak("leetcode",dict));
	assertTrue(wordBreak("leetwordcodekey",dict));
    }
}
