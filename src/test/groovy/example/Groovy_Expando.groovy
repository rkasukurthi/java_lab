package example

/**
 * 
 * If it walks like a duck and quacks like a duck, I would call it a duck.
 * In Groovy, the Expando class is an empty "it"! 
 * It is a container for various behaviours, to which we can add stuff. Check out this code sample:
 *
 * Expando are very useful for mocking in unit-tests
 * 
 * @author zluo
 *
 */

def duckTester = { duck -> duck.quack()}

def it = new Expando()

// add quacking
it.quack = {println "quack!"}


duckTester(it)


/**
 * Developer Testing using Maps and Expandos instead of Mocks
 * 
 */

//Suppose we are trying to test the following application:

class MyApp {
	def factory
	def logger
	def doBusinessLogic(param) {
		def myObj = factory.instance
		myObj.doSomething(param)
		myObj.doSomethingElse(param)
		logger.log('Something done with: ' + param)
	}
}


class MyAppTest extends GroovyTestCase {
	void testDoesBusinessLogic() {
		// triangulate
		checkDoesBusinessLogic "case1"
		checkDoesBusinessLogic "case2"
	}
	private checkDoesBusinessLogic(param) {
		def logger = setUpLoggingExpectations(param)
		def businessObj = setUpBusinessObjectExpectations(param)
		def factory = [instance: businessObj]
		def cut = new MyApp(logger:logger, factory:factory)
		cut.doBusinessLogic(param)
	}
	private setUpLoggingExpectations(param) {
		def shouldProduceCorrectLogMessage =
			{ msg -> assert msg == 'Something done with: ' + param }
		def logger = new Expando()
		logger.log = shouldProduceCorrectLogMessage
		return logger
	}
	private setUpBusinessObjectExpectations(param) {
		def shouldBeCalledWithInputParam = { assert it == param }
		def myObj = new Expando()
		myObj.doSomething = shouldBeCalledWithInputParam
		myObj.doSomethingElse = shouldBeCalledWithInputParam
		return myObj
	}
}




