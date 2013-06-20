package date;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TimeExpired {

	int expirePeriod=5; //5 second
	
	Date sentOn;
	
	boolean isExpired()
	{
		Date avildTime = new Date(new Date().getTime() - (expirePeriod * 1000));
		return sentOn.before(avildTime);
	}
	
	@Test
	public void testExpired() throws InterruptedException
	{
		sentOn = new Date();
		Thread.sleep(2*1000);
		assertFalse(isExpired());
		
		Thread.sleep(5*1000);
		
		assertTrue(isExpired());
		
	}
	
}
