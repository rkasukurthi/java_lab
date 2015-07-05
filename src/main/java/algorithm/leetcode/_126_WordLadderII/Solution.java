package algorithm.leetcode._126_WordLadderII;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * Return [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 * 
 * Note: All words have the same length. All words contain only lowercase
 * alphabetic characters.
 * 
 * @author zluo
 *
 */
public class Solution {
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	return null;
    }
    
    
    @Test
    public void test1() {
	Set dic = new HashSet<String>();
	dic.add(new String[]{"hot","dot","dog","lot","log"});
	assertEquals(2, findLadders("hit","hot",dic).size());
    }
}
