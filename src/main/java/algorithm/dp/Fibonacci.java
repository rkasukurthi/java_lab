package algorithm.dp;

import org.junit.Test;

public class Fibonacci {

    public int solution(int n){
	return fib(n);
    }
    
    int fib(int n){
	System.out.println("" + n + " is called");
	if (n==1 || n==2) return 1;
	else
	    return fib(n-1)+fib(n-2);
    }
    
    @Test
    public void test(){
	solution(5);
    }
}
