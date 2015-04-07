package string;

import org.junit.Test;

public class SprintPrint {

	String content ="";
	
	@Test
	public void testPrint(){
		String[] a = content.split(" ");
		for(String str: a){
			System.out.print(str);
		}
	}
}
