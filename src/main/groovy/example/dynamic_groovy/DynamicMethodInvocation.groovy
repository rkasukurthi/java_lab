package example.dynamic_groovy

//You can invoke a method even if you don't know the method name until it is invoked:

class Dog {
	def bark() {println "woof!"}
	def sit() {println "(sitting)"}
	def jump() {println "boing!"}
}

def doAction (animal, action)
{
	animal."$action"()
}

def rex = new Dog()

doAction (rex, "bark")
doAction (rex, "jump")


//You can also "spread" the arguments in a method call, when you have a list of arguments:
def max(int i1, int i2)
{
	Math.max(i1,i2)
}

def numbers=[1,2]
assert max(*numbers)==2



class MyClass implements GroovyInterceptable {
	def invokeMethod(String name, args) {
		System.out.println ("Beginning $name")
       def metaMethod = metaClass.getMetaMethod(name, args)
		def result = metaMethod.invoke(this, args)
     System.out.println ("Completed $name")
		return result
	}
	
	void method()
	{
		System.out.println("Call method")
	}
}

new MyClass().method();


//Overriding getProperty and setProperty

class Expandable {
	def storage = [:]
	def getProperty(String name) { storage[name] }
	void setProperty(String name, value) { storage[name] = value }
}

def e = new Expandable()
e.foo = "bar"

println e.foo



