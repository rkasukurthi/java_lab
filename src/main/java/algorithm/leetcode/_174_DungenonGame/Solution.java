package algorithm.leetcode._174_DungenonGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class Solution {
    /**
     * The demons had captured the princess (P) and imprisoned her in the
     * bottom-right corner of a dungeon. The dungeon consists of M x N rooms
     * laid out in a 2D grid. Our valiant knight (K) was initially positioned in
     * the top-left room and must fight his way through the dungeon to rescue
     * the princess.
     * 
     * The knight has an initial health point represented by a positive integer.
     * If at any point his health point drops to 0 or below, he dies
     * immediately.
     * 
     * Some of the rooms are guarded by demons, so the knight loses health
     * (negative integers) upon entering these rooms; other rooms are either
     * empty (0's) or contain magic orbs that increase the knight's health
     * (positive integers).
     * 
     * In order to reach the princess as quickly as possible, the knight decides
     * to move only rightward or downward in each step.
     * 
     * 
     * @param dungeon
     * @return
     */
    
    int cache[][];
    public int calculateMinimumHP(int[][] dungeon) {
	int i =dungeon.length;
	int j =dungeon[0].length;
	cache= new int[i][j];
	return findMinHealth(i-1,j-1,1,dungeon);
    }
    
    private int findMinHealth(int i, int j, int minHealth, int[][] dungenon){
	
	System.out.println("i =" +  i + ", j= " + j + " health = " + minHealth);
//	if (cache[i][j] >0) return cache[i][j];
	
	if (dungenon[i][j]>0){
	//    cache[i][j]=minHealth;
	}
	else{
	    cache[i][j]=minHealth=minHealth-dungenon[i][j];
	}
	if (i==0) {
	  if (j>0) {
	    return findMinHealth(i, j-1, cache[i][j], dungenon);
	  }else {
	    return cache[i][j];
	  }
	}
	if (j==0) {
	  return findMinHealth(i-1, j, cache[i][j], dungenon);
	}
	return Math.min(findMinHealth(i-1, j, cache[i][j], dungenon), findMinHealth(i, j-1, cache[i][j],dungenon));
    }
    @Test
    public void test(){
	int[][] dungeon={{-5,-1,1},{-3,-2,-2},{-2,-3,-1}};
	assertEquals(9,calculateMinimumHP(dungeon));
    }
    
}
