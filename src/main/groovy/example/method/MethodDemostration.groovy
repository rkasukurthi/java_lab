package example.method

class MyClass {
	
	def hello(){ 'invoked hello directly' }

	// define a invokeMethod when the method is missing
		
	def invokeMethod(String name, Object args){
	  return "unknown method $name(${args.join(', ')})"
	}
}

	def mine= new MyClass()
	assert mine.hello() == 'invoked hello directly'
	assert mine.foo("Mark", 19) == 'unknown method foo(Mark, 19)'
	

		class MyClass1 implements GroovyInterceptable{
		def hello(){  println   "XXXX"
			'invoked hello() directly' }
		
		def invokeMethod(String name, Object args){
			  "invoked method $name(${args.join(', ')})"
		}
	  }
	  def mine1= new MyClass1()
	  assert mine1.hello() == 'invoked method hello()'
	  assert mine1.foo('Mark', 19) == 'invoked method foo(Mark, 19)'
	  
	  assert mine1.&hello() == 'invoked hello() directly'
	  
	  /**
	   * If class extends GroovyInterceptable,  invokemethod will interceptable all method call
	   * @author zluo
	   *
	   */
	  
	  class MyClass2 implements GroovyInterceptable{
		  def greeting= 'accessed greeting'
		  def id= 'White: '
		
		  Object getProperty(String property){
			try{
			  return this.@id + //access field directly
					 'indirectly ' +
					 this.@"$property" //access field directly and dynamically
			}catch(e){
			  return "no such property $property"
			}
		  }
		
		  def hello(Object[] args){ "invoked hello with (${args.join(', ')})" }
		  def id(){ 'Green: ' }
		
		  def invokeMethod(String name, Object args){
			try{
			  return this.&id() + //call method directly
					 'indirectly ' +
					 this.&"$name"(args) //call method directly and dynamically
			}catch(e){
			  return "no such method $name"
			}
		  }
		}
		
		def mine2= new MyClass2()
		assert mine2.greeting == 'White: indirectly accessed greeting'
		assert mine2.farewell == 'no such property farewell'
		
		assert mine2.hello(1, 'b', 3) == 'Green: indirectly invoked hello with (1, b, 3)'
		assert mine2.foo('Mark', 19) == 'no such method foo'
		
		
		//MetaClasses 
		class A{
			def bark(){ 'A: invoked bark()' }
			def invokeMethod(String name, Object args){
			  "A: missing $name(${args.join(', ')})"
			}
		  }
		  def a= new A()
		  assert a.bark() == 'A: invoked bark()'
		  assert a.bleet() == 'A: missing bleet()'
		  
		  
		  