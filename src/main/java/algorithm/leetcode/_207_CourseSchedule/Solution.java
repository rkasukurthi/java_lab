package algorithm.leetcode._207_CourseSchedule;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible. See
 * 
 * http://en.wikipedia.org/wiki/Topological_sorting for the algorithm.
 * 
 * @author zluo
 *
 */
public class Solution {
    
    List<List<Integer>> adjs = new ArrayList<>();
    boolean[] visited;
    boolean[] onStack;
    public boolean canFinish(int numCourses, int[][] prerequisites){
	if (numCourses <=1) return true;
	for (int i=0; i<numCourses;i++){
	    adjs.add(new ArrayList());
	}
	for(int[] edge: prerequisites){
	    adjs.get(edge[0]).add(edge[1]);
	}
	visited = new boolean[numCourses];
	onStack = new boolean[numCourses];
	return !hasCycle();
	
    }
    
    boolean hasCycle(){
	for(int i=0; i<visited.length; i++){
	    if (visited[i]==false){
		if (dfs(i) == true) return true;
	    }
	}
	return false;
    }
    
    private boolean dfs(int i){
	visited[i]=true;
	onStack[i]=true;
	for(int j: adjs.get(i)){
	    if (visited[j]==false){
		if (dfs(j)==true) return true;
	    }else if (onStack[j]==true){
		return true;
	    }
	}
	onStack[i]=false;
	return false;
    }
/*    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        List<List<Integer>> adjs = new ArrayList<>();
        
        boolean[] visited = new boolean[numCourses];
        
        *//** init data structure**//*
        for(int i=0;i<numCourses; i++){
          adjs.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites){
            adjs.get(edge[0]).add(edge[1]);
        }
        return !hasCycle(adjs, visited);
    }

    private boolean hasCycle(List<List<Integer>> adjs, boolean[] visited) {
        boolean[] onStack = new boolean[visited.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                if (dfs(i, adjs, visited, onStack) == true) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adjs, boolean[] visited, boolean[] onStack) {
        visited[node] = true; onStack[node] = true;
        for (int to : adjs.get(node)) {
            if (visited[to] == false) {
                if (dfs(to, adjs, visited, onStack) == true) return true;
            } else if (onStack[to] == true) {
                return true;
            }
        }
        onStack[node] = false;
        return false;
    }*/
    
    @Test
    public void test1() {
	assertEquals(false, canFinish(2, new int[][] { { 1, 0 }, { 0, 1 },{1,2}}));
    }
}
