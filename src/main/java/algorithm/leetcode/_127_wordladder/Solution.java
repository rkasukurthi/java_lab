package algorithm.leetcode._127_wordladder;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Given two words (beginWord and endWord), and a dictionary, find the length of
 * shortest transformation sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As
 * one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters.
 * 
 * @author zluo
 *
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
	return 0;
    }
    
    @Test
    public void testCase1(){
	assertEquals(5, ladderLength("hit", "cog", new HashSet(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}))));
    }
    @Test
    public void testCase2(){
	assertEquals(1, ladderLength("hot", "hot", new HashSet(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}))));
    }
    @Test
    public void testCase3(){
	assertEquals(0, ladderLength("hot", "hot", new HashSet(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}))));
    }
}
