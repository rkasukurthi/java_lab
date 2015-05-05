package algorithm.leetcode._139_WordBreak;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
	return wordBreak(0,s,wordDict);
    }
    public boolean wordBreak(int i, String s, Set<String> wordDict) {
	int e=i;
	while( e<s.length()){
	    
	}
	return false;
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
