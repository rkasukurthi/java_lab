package example

/*
 * Define Interface
 */
interface Logger {
	def log(message)
}

interface Helper {
	def doSomething(param)
	def doSomethingElse(param)
}

interface Factory {
	Helper getInstance()
}


class MyApp1 {
	private Logger logger
	private Factory factory
	
	private MyApp1( Factory factory, Logger logger) {
		this.logger = logger;
		this.factory = factory;

		}

	def doMyLogic(param)
	{
		factory.getInstance().doSomething(param)
		logger.log("Something done with: " + param)
	
	}
	
}


/*
 * Test
 * 
 * The point is define a closure as the interface, in this case, the closure body will be placed as the interface body
 * one more this is how to define interface in groovy.
 */

def param='DUMMY STRING'
def logger= {message -> assert message=="Something done with: " + param}
def helperMethod= {assert it==param}
def helper=[doSomething:helperMethod, doSomethingElse:helperMethod]
def factory= {helper as Helper}
def myApp = new MyApp1(factory as Factory, logger as Logger)

myApp.doMyLogic(param)



