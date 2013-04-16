package example.method

public class MyMetaClass extends DelegatingMetaClass{
  MyMetaClass(Class theClass){
    super(theClass)
  }
  Object invokeMethod(Object object, String methodName, Object[] arguments){
    "MyMetaClass: ${super.invokeMethod(object, methodName, arguments)}"
  }
}

public class MyOtherMetaClass extends DelegatingMetaClass{
  MyOtherMetaClass(Class theClass){
    super(theClass)
  }
  Object invokeMethod(Object object, String methodName, Object[] arguments){
    "MyOtherMetaClass: ${super.invokeMethod(object, methodName, arguments)}"
  }
}

class A1{
  def bark(){ 'A: invoked bark()' }
  def invokeMethod(String name, Object args){
    "A: missing $name(${args.join(', ')})"
  }
}

def amc= new MyMetaClass(A)
amc.initialize()
def a= new A1()
a.metaClass= amc
    //using metaClass property on an instance affects only that instance...

def amc2= new MyOtherMetaClass(A)
amc2.initialize()
def a2= new A1()
a2.metaClass= amc2

assert a.bark() == 'MyMetaClass: A: invoked bark()'
assert a2.bark() == 'MyOtherMetaClass: A: invoked bark()'

Thread.start{                                   //...even in a new thread
  assert a.bark() == 'MyMetaClass: A: invoked bark()'
  assert a2.bark() == 'MyOtherMetaClass: A: invoked bark()'
}

assert new A1().bark() == 'A: invoked bark()'
    //new instances don't have new MetaClass

assert a.bleet() == 'A: missing bleet()'
    //MetaClass invokeMethod() NOT called here