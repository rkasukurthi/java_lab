package example.closure

/**
 * Understanding closure
 * 
 * http://groovy.codehaus.org/Closures+-+Informal+Guide
 * @author zluo
 *
 */

	def x=2
	
	// Define the closure
	def c= {number -> number*number}
	
	// Call the closure in shorthand
	def y=c(x)  // shorthand
	
	// Call the closure in longhand
	def z=c.call(x) //longhand
	assert y==z

	public class GVector extends java.util.Vector
	{

// closure as the parameters
		
		public void apply(c)
		{
			for (i in 0..<size())
			{
				this[i]=c(this[i])
			}
		}
	}
	
	def gVect = new GVector()
	gVect.add(2)
	gVect.add(3)
	gVect.add(4)
	
	def c1= {println(it)}
	
	gVect.apply(c)
	gVect.apply(c1)
	
	
	println " Exmaple Employee ------------------------------------------------"
	
	class Employee{
		def salary
	}
	
	def highPaid(emps)
	{
		def threshold=150
		return emps.findAll{e-> e.salary > threshold}
	}
	
	
	def emps=[180,140,160].collect{val->new Employee(salary:val)}
	
	println emps.size()
	println highPaid(emps).size()
	
	
	
	println """Example User:------------------------------------------------"""
	
	// sample entity
	class User{
	 def username, password, version, salt = 'RANDOM';
	}
	
	// your API, provide a Map of changes to update a entity. the map value may be static value, or a closure that take up to 2 params
	def update( entity, Map changes ){
	 changes?.each {k, v ->
	  def newValue;
	  if (v instanceof Closure){
	   switch (v.parameterTypes.length) {
		case 0: newValue = v(); break;
		case 1: newValue = v(entity[k]); break; // if one params, the closure is called with the field value
		case 2: newValue = v(entity[k],entity); break; // if two params, the closure is called with teh field value and the entity
	   }
	  }else{
	   newValue = v
	  }
	  entity[k] = newValue
	 }
	}
	
	// user code
	def user1 = new User(username:'user1', password:'pass1', version:0)
	update( user1, [password:{p,e-> Hash.md5(p, e.salt) }, version:{v-> v+1 }]) //assume there is a MD5 util
	
	
	
	
	
	
	
	
	
	
	
	
	
	