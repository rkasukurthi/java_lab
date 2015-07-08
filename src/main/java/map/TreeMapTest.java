package map;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class TreeMapTest {
    
    /**
     * 
     */
    
    @Test
    public void testTreeMapSort(){
	Map<String, Integer> map = new TreeMap<String, Integer>(new Comparator(){

            public int compare(Object o1, Object o2) {
	        return 0;
            }
	});
	
	map.put("A", 3);
	map.put("D", 4);
	map.put("B", 2);
	map.put("C", 1);
	
	
	Map sortedMap =sortByValues(map);
	
	System.out.println (Arrays.toString(map.values().toArray()));
	
    }
    
    
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator =  new Comparator<K>() {
	        public int compare(K k1, K k2) {
	            int compare = map.get(k2).compareTo(map.get(k1));
	            if (compare == 0) return 1;
	            else return compare;
	        }
	    };
	    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	}
}
