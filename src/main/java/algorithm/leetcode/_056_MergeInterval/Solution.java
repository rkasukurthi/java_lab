package algorithm.leetcode._056_MergeInterval;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
	int lo=0;
	int hi=intervals.size()-1;
	
	mergeSort(lo, hi, intervals);
	
	
	
	
	
	return intervals;
	
    }
    
    public void mergeSort(int lo, int hi, List<Interval> intervals){
	
	
	if (lo<hi){
	    int mid =lo +(hi-lo)/2;
	    mergeSort(lo,mid,intervals);
	    mergeSort(mid+1,hi,intervals);
	}
    }
    
    @Test
    public void test() {
	List<Interval> list = new ArrayList<Interval>();
	list.add(new Interval(1, 3));
	list.add(new Interval(2, 6));
	list.add(new Interval(8, 10));
	list.add(new Interval(15, 18));
	
	assertEquals(3, merge(list));
    }
    
}