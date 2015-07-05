package datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Print the level of friendship.
 * 
 * Given a person and list of his friends, print all his friends by level of
 * association.
 * 
 * The text file will be like one below
 * 
 * A: B,C,D
 * D: B,E,F 
 * E: C,F,G
 * 
 * If the input is A, the out put should be:
 * 
 * Level 1 - B,C,D Level 2 - E,F Level 3 - G
 * 
 * @author zluo
 *
 */
public class PrintFriendByLevelOfAssociation {
     
    Map<String, List<String>> adj = new HashMap<String,List<String>>();
    Set<String> visited = new HashSet<String>();
    int level=1;
    
    void printFriendLevel(String key){
      Set<String> edges = new HashSet<String>();
      edges.add(key);
      printEdges(edges);
    }
    
    void printEdges(Set<String> edges ){
	Set<String> leveledEdges = new HashSet<String>();
	for (String edge: edges){
	    List<String> list = adj.get(edge);
	    if (list !=null){
		for(String e: list){
		    if (!visited.contains(e)){
			visited.add(e);
			leveledEdges.add(e);
		    }
		}
	    }
	}
	if (leveledEdges.size()>0){
           System.out.println("Level " + (level++) + ": " + String.join(",", leveledEdges));
	    printEdges(leveledEdges);
	}
    }
    
    void addEdges(String key, String edges){
	List edgeList = adj.get(key);
	if (edgeList==null){
	    adj.put(key, new ArrayList<String>());
	}
	String[] edgesArr = edges.split(",");
        for(String edge: edgesArr){
            adj.get(key).add(edge);
        }
    }
    
    
    
    @Test
    public void test(){
     addEdges("A", "B,C,D");	
     addEdges("D", "B,E,F");	
     addEdges("E", "C,F,G");	
     printFriendLevel("A");
    }
    
    
}
