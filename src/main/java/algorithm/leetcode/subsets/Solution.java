package algorithm.leetcode.subsets;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 * 	[3],
 * 	[1],
 *	[2],
 * 	[1,2,3],
 * 	[1,3],
 * 	[2,3],
 * 	[1,2],
 * 	[]
 * ]
 * Solution.java
 * @author zluo
 *
 *https://leetcode.com/problems/subsets-ii/
 */
public class Solution {
    
 /** Non Recursive **/   
 public List<List<Integer>> subsets(int[] S) {
     
    Arrays.sort(S);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    list.add(new ArrayList<Integer>());
    if (S==null || S.length==0) return list;
    
    for (int i=0;i<S.length;i++){
	int size = list.size();
	for(int j=0; j<size; j++){
	    ArrayList<Integer> item = new ArrayList<Integer>(list.get(j));
	    item.add(S[i]);
	    list.add(item);
	}
    }
    
    return list;
    }
 
 /**Recursive**/   
 public List<List<Integer>> subsetsRecur(int[] S) {
     
     Arrays.sort(S);
     List<List<Integer>> list = new ArrayList<List<Integer>>();
     list.add(new ArrayList<Integer>());
     if (S==null || S.length==0) return list;
     
     for (int i=0;i<S.length;i++){
	 int size = list.size();
	 for(int j=0; j<size; j++){
	     ArrayList<Integer> item = new ArrayList<Integer>(list.get(j));
	     item.add(S[i]);
	     list.add(item);
	 }
     }
     
     return list;
 }
 /** Non Recursive **/   
 public List<List<Integer>> subsetsWithDup(int[] S) {
    
    Set<Integer> set = new HashSet<Integer>();
	
    Arrays.sort(S);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    list.add(new ArrayList<Integer>());
    if (S==null || S.length==0) return list;
    
    for (int i=0;i<S.length;i++){
	int size = list.size();
	for(int j=0; j<size; j++){
	    ArrayList<Integer> item = new ArrayList<Integer>(list.get(j));
	    item.add(S[i]);
	    int key =generateKey(item);
	    if (!set.contains(key)){
		list.add(item);
		set.add(key);
	    }
	}
    }
    
    return list;
    }
 
 /**
  * This is the general hashcode method
  * @param item
  * @return
  */
 private int generateKey(List<Integer> item){
	int result =1;
	for(Integer i: item){
	    result = 31*result + i;
	}
	return result;
 }
 
 @Test
 public void testSubset2(){
     int[] a = {1,2,2,3};
     List<List<Integer>> list = subsetsWithDup(a);
     assertEquals(12, list.size());
 }
 @Test
 public void testSubset(){
     int[] a = {1,2,3};
     List<List<Integer>> list = subsets(a);
     assertEquals(8, list.size());
 }
 
 @Test
 public void testSubsetRecursive(){
     int[] a = {1,2,3};
     List<List<Integer>> list = subsetsRecur(a);
     assertEquals(8, list.size());
 }
 
}
