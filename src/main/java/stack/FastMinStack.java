package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class FastMinStack
{
   int[] data= new int[1024];
   int size=0;
   int min=0;	
	public void push(int val){
	    if (size==0){
	    	data[size]=val;
	    	min=val;
	    }else if(val<min){
	    	data[size]=val + (val-min);
	    	min=val;
	    }else{
	    	data[size]=val;
	    }
		size++;
   }
   
   public int pop(){
	size--;
	int val =data[size];
	if ((size>0) && (val<min)){
		int prevMin =min;
		min +=min-val;
		return prevMin;
	}else{
		return val;
	}
   }
   
   public boolean isEmpty(){
	return size==0;
	   
   }
   
   public int getMin(){
	return min;
   }
   
   
   @Test
   public void testCase1(){
	   FastMinStack stack = new FastMinStack();
	   
	   int[] a = {7,5,2,3,1,4,3};
	   
	   for(int i=0; i<a.length; i++){
		   stack.push(a[i]);
	   }
	   assertEquals(1,stack.getMin());
	   assertEquals(1,stack.getMin());
	   assertEquals(3,stack.pop());
	   assertEquals(4,stack.pop());
	   assertEquals(1,stack.pop());
	   assertEquals(2,stack.getMin());
	   assertEquals(3,stack.pop());
	   assertEquals(2,stack.pop());
	   assertEquals(5,stack.getMin());
	   assertEquals(5,stack.pop());
	   assertEquals(7,stack.getMin());
   }
}
