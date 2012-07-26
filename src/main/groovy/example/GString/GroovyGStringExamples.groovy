package example.GString


/**
 * Example 1
 * Groovy use both " and ' for Strings
 */
println "Example 1: "
println "---------------------------------------"
println "he said 'chess' once"
println 'he said "chess" again'



println " "
println 'Example 2:  This example shows the feature of  """\\ syntax'
println "---------------------------------------"

def name="James"
def text="""\
<h1> hello world </h1>
	hello there ${name}
	how are you today?
My name is Smith
"""
assert text !=null
println(text)


println " "
println 'Example 3:  This example shows the feature of  Slashy String literals'
println "---------------------------------------------------------------------"

def s=/.*foo.*/
def dirname=/^.*\//
//def basename=/[Strings and GString^\/]+$/

assert 'ab'== 'a' +'b'
assert 'a' + 'b'==/ab/
assert (/ab/ =='a' + 'b')


println " "
println 'Example 4:  Strings are immutable'
println "---------------------------------------------------------------------"


st = ["status": "test"]
sn=st
print sn.status
st.status="tset"
println sn.status
println "--->"

st = 'test'
sn=st
print sn
st="tset"
println sn

println " "

/**
 * example 1 Abbreviated dallar syntax,
 * every $ is an expression
 */
me= 'Tarzan'
you='Jane'
line="me $me - you $you"
assert line=='me Tarzan - you Jane' 

/**
 * example 2 Extended abbreviation
 */

date=new Date(0)
out="Year $date.year Month $date.month Day $date.date"
println out
assert out=='Year 69 Month 11 Day 31'

println "Date is ${date.toGMTString()}!"

/**
*Gstring as template with closure
*
*out << return
*/

def noParam = { -> println "I'm executed"; return "no param" }
def oneParam = { out -> println "Executed with a ${out.class} parameter"; out << "one param 1" }

assert noParam.toString() != "no param"

println "${noParam} - ${oneParam}"





