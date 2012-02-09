package example.dsld;
import groovy.util.GroovyTestCase;


/**
 * Test Distance DSL  
 * 
 * @author zluo
 *
 */
class DistanceTest extends GroovyTestCase {
	
	void testSomething()
	{
		use(DistanceCategory.class){
			def d1=1.m
			def d2=1.yd
			def d3=1760.yd
			def d4=100.cm

			println d1 + 1.yd
			println 1.yd + 1.mi
			println 1.m - 1.yd
			println d2.m
			println d3.mi
			println d4.m
			println 1000.yd.km
			println 1000.yd 
						
		 }
	}
    
}
