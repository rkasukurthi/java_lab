package algorithm.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CombinationOfString {
    Set<String> set=new HashSet<String>(); 
    int count=0;
    void combine(String instr, StringBuilder outstr, int index)
    {
	for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            System.out.println(outstr);
            set.add(outstr.toString());
            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    } 
    
    @Test
    public void test(){
	String s="abcd";
	combine(s,  new StringBuilder(), 0);
//	combine(new StringBuilder(s).reverse().toString(),  new StringBuilder(), 0);
	System.out.println(Arrays.toString(set.toArray()));
    }
}
