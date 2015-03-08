package format;

import java.util.Calendar;
import java.util.Locale;

/**
 * Example Code for String.format()
 * @author zluo
 *
 */
public class FormattingDemo {
	
	public static void main(String[] args)
	{
		String s= String.format("Welcome %s at %s", "zhan", "montreal");
		System.out.println(s);
		
		// re order output and specify the string length
		s= String.format("%4$20s %3$20s %2$20s %1$20s", "a","b","c", "d");
		System.out.println(s);
		
		
		//Optional locale as the first argument can be used to get
		//locale-specific formatting of numbers. The precision and width can be 
		//given to round and align the value.
		
		s= String.format("e = %+10.4f", Math.E);
		System.out.println(s);
		
		s= String.format(Locale.FRANCE, "e = %+10.4f", Math.E);
		System.out.println(s);
		
		 // The '(' numeric flag may be used to format negative numbers with
		   // parentheses rather than a minus sign.  Group separators are
		   // automatically inserted.
		 s=String.format("Amount gained or lost since last statement: $ %(,.2f",
		                    -6217.58);
		   // -> "Amount gained or lost since last statement: $ (6,217.58)"
		 System.out.println(s);
		
		 System.out.format("Local Time:%tT", Calendar.getInstance());
	}

}
