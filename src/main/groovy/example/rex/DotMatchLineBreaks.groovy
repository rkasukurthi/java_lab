package example.rex
/**
 * 
 * This example show the multiple line content example 
 * 
 * 
 * @author zluo
 *
 */

//Content include the 'Line 1\nLine 2\nLine 3' 
def content ='''Line 1
Line 2
Line 3'''
println "------Match /.+/-------------"
matcher = content=~/.+/
matcher.each {it ->
	println "<>" + it}



println "---------Match /[\\s\\S]*/----------"
matcher = content=~/[\s\S]*/
matcher.each {it->
	println "<>" + it}

println "---------Match /(?s).*+/ Single line mode----------"

//(?s) means 'dot match break line'
matcher = content=~/(?s).*+/

matcher.each {println "<>" + it}

println '---------Match multiple line mode /(?m)^.*$/----------'

//(?s) means 'dot match break line'
matcher = content=~/(?m)^.*$/

matcher.each {println "<multiple line mode>" + it}

println '------Match /(?s)^.+$/-------------'
matcher = content=~/(?s)^.+$/
matcher.each {it ->
	println "<>" + it}



