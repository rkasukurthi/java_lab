package date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * This example learns how to make the difference between two dates and how to convert milliseconds into seconds,
 *  seconds into minutes, minutes into hours, hours into days.
 *  Here we are using Calendar, an abstract base class that extends Object class and makes a difference between a
 *  Date object and a set of integer fields. Calendar class provides a getInstance()  method for returning a Calendar 
 *  object whose time fields have been initialized with the current date and time.
 *  The methods used:
 *  setTimeInMillis(long millis): This method is used to set current time in calendar object.
 *  getInstance(): This method is used to get a calendar using the default time zone, locale and current time.
 *   
 * @author zluo
 *
 */
public class DateDifferent {

   public static void main(String[] args)  
   {
	   dayLeft();
   }
   static void dayLeft()
   {
	    Calendar c = new GregorianCalendar(2009, 10, 19);
	    Date d1 = new GregorianCalendar(2009, 10, 19).getTime();

	    /** Today's date */
	    Date today = new Date();

	    // Get msec from each, and subtract.
	    long diff = today.getTime() - d1.getTime();
	    
	    System.out.printf(" Today is %1$tb %1$te,%1$tY,%1$tA\n", today);
	    System.out.printf(" Your goal was setup on %1$tb %1$te,%1$tY,%1$tA\n", c);

	    System.out.println(" You Goal of SCEA (up to " + today + ") is only "
	    		+ (1000- diff / (1000 * 60 * 60 * 24)) + " days left. Are you readY?");
	    
   }
}
