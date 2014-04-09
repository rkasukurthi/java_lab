import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class MathResolver {
	
	boolean[] numberTakens = {false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
	int[] maze=	{-1,0,0,0,0,20,0,0,0,0,0,0,0,0,0,0,0,0,0,0,13,0,0,0,0,0};
	Stack[] stacks= new Stack[25];
	
	
	public static void main(String[] args)
	{
		MathResolver  mr= new MathResolver();

		
	}
	
	 public void find()
	 {
		numberTakens[20]=false;
		numberTakens[13]=false;
		
		 
		 int current=20;
		 int end=13;
			int i =7;
			Stack<Integer> value = new Stack();
    		value.push(20);
			
			while (i<21)
			{
				Stack<Integer> stack = findPossibility(current);
				if (stack.size()>0)
				{
					current=stack.pop();
					value.push(current);
					i++;
				}
				else
				{
					
				}
				
			}
	 }
	 public Stack<Integer> findPossibility(Integer number)
	{
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=1; i<=7; i++)
		{
			int j = i*i -number;
			if (j>0 && j<=25 && isAvailable(j))
			{
				stack.push(j);
			}
		}
		return stack;
	}
    
	 
	 public static boolean isSquare(int i, int j)
	 {
		 int k=i+j;
		 if (k==1 || k==4 ||k==9 || k==16 || k==25 || k==36 || k==49)
		 {
			 return true;
		 }
		 return false;
	 }
	 
	 
	 boolean isAvailable(int number)
	{
		return numberTakens[number];
	}

}
