package example.GString

/**
 * example 1 Abbreviated dallar syntax
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
*
*/