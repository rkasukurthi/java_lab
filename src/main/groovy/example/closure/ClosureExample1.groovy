package example.closure


/**
 * Owner_first
 * 
 * @author zluo
 *
 */
 class Test {
     def x = 30
     def y = 40

     def run() {
         def data = [ x: 10, y: 20 ]
         def cl = { y = x + y }
         cl.delegate = data
         cl()
         println x
         println y
         println data
     }
 }

 new Test().run()

/**
 * Deletgate_first 
 */
 
 
 
 
 /**
  * Closure  this, owner and delegate
  */
 class Class1 {
	 def closure = {
	   println this.class.name
	   println delegate.class.name
	   println owner.class.name
	   def nestedClos = {
    	 println "nestedClos: <this.class.name>" +  this.class.name
		 println owner.class.name
		 println delegate.class.name
	   }
	   nestedClos()
	 }
   }
   
   def clos = new Class1().closure
   clos.delegate = this
   clos()
 
