package mockito.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class HamrestSample {
  
  @Test
  public void testWithMatchers(){
   assertThat ("this string", is("this string"));
   assertThat(123, is(123));
  }

}
