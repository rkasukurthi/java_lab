package date.joda;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

public class JodaTest {
  
  @Test
  public void testDateTime()
  {
    DateTime now = new DateTime("2014-09-03T15:34:44.870-04:00");
    System.out.println(now);
    
    DateTime yesterday =now.minusDays(1);
    System.out.println(yesterday);
    
    assertEquals(yesterday.toString(), "2014-09-02T15:34:44.870-04:00");
    
  }
  

}
