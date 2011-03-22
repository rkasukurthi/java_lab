package Format;

public class FormattingDemo {
	
	public static void main(String[] args)
	{
		String s= String.format("Welcome %s at %s", "zhan", "montreal");
		System.out.println(s);
		
		// re order output and specify the string length
		s= String.format("%4$20s %3$20s %2$20s %1$20s", "a","b","c", "d");
		System.out.println(s);
		
	}

}
