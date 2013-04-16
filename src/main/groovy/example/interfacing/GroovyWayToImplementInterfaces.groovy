package example.interfacing

/**
 * An interface with a single method can be implemented with a closure like so:
 */

// a readable puts chars into a CharBuffer and returns the count of chars added
def readable = { it.put("12 34".reverse()); 5 } as Readable

// the Scanner constructor can take a Readable
def s = new Scanner(readable)
assert s.nextInt() == 43

/** You can also use a closure to implement an interface with more than one method. 
*The closure will be invoked for each method on the interface. Since you need a closure
* whose parameter list matches that of all of the methods you typically will want to
* use an array as the sole parameter. This can be used just as it is for any Groovy
*  closure and will collect all of the arguments in an array. For example:
*/

interface X
{ void f(); void g(int n); void h(String s, int n); }

x = {Object[] args -> println "method called with $args"} as X
x.f()
x.g(1)
x.h("hello",2)

/**
 * Implement as map
 */
y= [f:{println "f called"}, g:{println "g called"}] as X

y.f()
y.g(2)
