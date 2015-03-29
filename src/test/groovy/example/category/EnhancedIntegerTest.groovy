package example.category;

import groovy.util.GroovyTestCase;

class EnhancedIntegerTest extends GroovyTestCase {


	void testEnhancedInteger() {
		use(EnhancedInteger) {
			assert 4.greaterThanAll([1,2,3])
			assert !5.greaterThanAll([2, 4, 6])
			assert 5.greaterThanAll(-4..4)
			assert 5.greaterThanAll([])
			assert !5.greaterThanAll([4, 5])
		}
	}
}
