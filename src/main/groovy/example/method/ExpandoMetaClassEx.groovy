package example.method

class AA{
	String text
}

def a1= new AA(text: 'aBCdefG')

// ? whtat's adaptee

assert a1.metaClass.adaptee.class== MetaClassImpl  //usual MetaClass type

// add a new method to the A's meta class.
A.metaClass.inSameCase= {->text.toUpperCase()}

def a2= new A(text: 'hiJKLmnOp')
assert a2.metaClass.adaptee.class== ExpandoMetaClass
assert a2.inSameCase()=='HIJKLMNOP'

assert a1.metaClass.adaptee.class== MetaClassImpl  //usual MetaClass type



