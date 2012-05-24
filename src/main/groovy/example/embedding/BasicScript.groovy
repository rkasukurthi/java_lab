package example.embedding

/**
 * Example 1 upto and closure
 */
def totalClinks=0
def partyPeople=100

println '========test closure========'
1.upto(partyPeople) {
	guestNumber ->
	clinksWithGuest=guestNumber-1
	totalClinks += clinksWithGuest
}
assert totalClinks == (partyPeople*(partyPeople-1))/2
println 'test result: totalClinks = ' + totalClinks 


println ' '
println 'test condition'


/**
 * Example 2 if condition
 */
// null is false
if (null) 
{ assert false
  println 'false'
}
else
{
	assert true
	println 'true'
}

/**
 *  Example 3 While condition 
 */

// classic while
def i=0
while (i<10)
{
	i++
}

assert i==10


/**
 * Example 4 For in range
 */

def clinks=0
for(remainingGuests in 0..9)
{
	clinks += remainingGuests
}

assert clinks ==(10*9)/2


/**
 *  Example 5 for in list
 */
def list=[0,1,2,3,4,5,6,7,8,9]
for(j in list)
{
	assert j ==list[j]
}

/**
 * Example 6 each method with a closure
 */
list.each {
	item ->
	assert item==list[item]
}

/**
 * Example 7 classic switch
 */
switch(3)
{
	case 1: assert false; break
	case 3: assert true; break
	default: assert false
}

/**
 * 
 * Example 8 The concept of optional typing
 */

def a=1
int b=1
Integer c=1
String f ='1'


/**
 * Example 9  Overriding operators
*/
assert a.plus(b)==2
assert a.minus(b)==0
assert a.equals(b)

/**
 * Examle 10 spaceship
 */

def a1='1'
def b1=' 1 '
assert a1.compareTo(b1)
assert a1<=>b1
//assert a1.equals(b1)


//def d1=new Distance(length : 2, unit : Unit.mm)
//println d1







