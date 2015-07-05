package algorithm.leetcode._210_CourseScheduleII;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * http://en.wikipedia.org/wiki/Topological_sorting for the algorithm.
 * 
 * @author zluo
 *
 */
public class Solution {
    
    List<List<Integer>> adjs = new ArrayList<>();
    List<Integer> courseOrder = new ArrayList<Integer>();
    boolean[] visited;
    boolean[] onStack;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
	int[] a = new int[numCourses];
	
	for (int i = 0; i < numCourses; i++) {
	    adjs.add(new ArrayList<Integer>());
	}
	
	
	for (int[] edge : prerequisites) {
	    adjs.get(edge[1]).add(edge[0]);
	}
	
	visited = new boolean[numCourses];
	onStack = new boolean[numCourses];
	for (int i = 0; i < adjs.size(); i++) {
	    try {
		dfs(i);
	    } catch (Exception e) { // if has cycle, return immediately.
		return new int[0];
	    }
	}
	
	for (int i = 0; i < a.length; i++) {
	    a[i] = courseOrder.get(a.length - 1 - i);
	}
	return a;
	
    }
    
    private void dfs(int i) throws Exception {
	if (visited[i] == true) return;
	if (onStack[i] == true) {
	    throw new Exception();
	}
	
	onStack[i] = true;
	for (Integer e : adjs.get(i)) {
	    dfs(e);
	}
	onStack[i] = false;
	courseOrder.add(i);
	visited[i] = true;
    }
    
    @Test
    public void test2() {
	int[] orders =findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
	System.out.println(Arrays.toString(orders));
	assertEquals(4, orders.length);
    }
    
    @Test
    public void test3() {
	assertEquals(4, findOrder(4, new int[][] {}).length);
    }
    
    @Test
    public void test4() {
	assertEquals(2, findOrder(2, new int[][] { { 0, 1 } }).length);
    }
}
