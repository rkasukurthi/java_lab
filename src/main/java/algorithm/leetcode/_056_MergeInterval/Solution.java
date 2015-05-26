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

/**
 * The idea of my algorithm is to sort and merge intervals at same time,instead of sorting first then merge intervals.
 * Implementation is following mergeSort algorithm, using divided and conquer.
 * the only difference is when doing sorting, also consider if these two intervals can be merged. 
 *
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
	return mergeSort(0, intervals.size()-1,intervals);
    }
    
    public List<Interval> mergeSort(int lo, int hi, List<Interval> intervals) {
	List<Interval> ret = new ArrayList<Interval>();
	if (lo> hi) return ret;
	if (lo==hi){
	    ret.add(intervals.get(lo));
	    return ret;
	}
	if (lo +1 == hi) {
	    Interval i1 = intervals.get(lo);
	    Interval i2 = intervals.get(hi);
	    if (i1.start < i2.start) {
		addOrMerge(ret,i1);
		addOrMerge(ret,i2);
	    }else{
		addOrMerge(ret,i2);
		addOrMerge(ret,i1);
	    }
	    return ret;
	}
	int mid =(hi-lo)/2 +lo;
	return merge(mergeSort(lo,mid,intervals), mergeSort(mid+1,hi,intervals));
    }
    
    /** merge two sorted list **/
    List<Interval> merge(List<Interval> list1, List<Interval> list2){
	List<Interval> ret = new ArrayList<Interval>();
	int i=0,j=0;
	int len1=list1.size(), len2=list2.size();
	
	while (i<len1){
	    if (j<len2){
		if (list1.get(i).start < list2.get(j).start){
		    addOrMerge(ret, list1.get(i++));
		}else{
		    addOrMerge(ret, list2.get(j++));
		}
	    }else break;
	}

	while(i<len1){
	   addOrMerge(ret,list1.get(i++));
	}

	while (j<len2){
	   addOrMerge(ret,list2.get(j++));
	}
	return ret;
    }
    
    /** Append or merge an interval to a sorted list */
    void addOrMerge(List<Interval> list, Interval interval) {
	if (list.size() == 0) {
	    list.add(interval);
	} else {
	    Interval last = list.get(list.size() - 1);
	    if (last.end >= interval.start) {
		last.end = Math.max(last.end, interval.end);
	    } else {
		list.add(interval);
	    }
	}
    }
    
    @Test
    public void test() {
	List<Interval> list = new ArrayList<Interval>();
	list.add(new Interval(1, 3));
	list.add(new Interval(2, 6));
	list.add(new Interval(8, 10));
	list.add(new Interval(2, 4));
	list.add(new Interval(15, 18));
	
	assertEquals(3, merge(list).size());
    }
    
    @Test
    public void test1() {
	List<Interval> list = new ArrayList<Interval>();
	list.add(new Interval(2, 3));
	list.add(new Interval(2, 2));
	list.add(new Interval(3, 3));
	list.add(new Interval(1, 3));
	list.add(new Interval(5, 7));
	list.add(new Interval(2, 2));
	list.add(new Interval(4, 6));
	
	assertEquals(2, merge(list).size());
    }
    
    @Test
    public void test2() {
	List<Interval> list = new ArrayList<Interval>();
	list.add(new Interval(2, 3));
	list.add(new Interval(2, 2));
	list.add(new Interval(3, 3));
	list.add(new Interval(1, 3));
	list.add(new Interval(5, 7));
	list.add(new Interval(2, 2));
	list.add(new Interval(4, 6));
	
	mergeSort(4,6,list);
    }
    
    @Test
    public void test3() {
	List<Interval> list = new ArrayList<Interval>();
	list.add(new Interval(2, 3));
	
	assertEquals(1, merge(list).size());
    }
    @Test
    public void test4() {
	List<Interval> list = new ArrayList<Interval>();
	list.add(new Interval(2, 3));
	list.add(new Interval(4, 5));
	list.add(new Interval(6, 7));
	list.add(new Interval(8, 9));
	list.add(new Interval(5, 7));
	list.add(new Interval(1, 10));
	
	assertEquals(1, merge(list).size());
    }
}