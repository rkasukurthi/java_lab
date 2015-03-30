package jn

import java.text.DecimalFormat

	// # means any, 0 means fixed
	assert new DecimalFormat('#,#00.0#').format(5.6789) =='05.68'

	// use square brackets[] to represent both ordered lists and key mappings
	def list=[1,2,3]
	def map =[1:'a', 2:'b', 3:'c']
	assert map[1]=='a'
	assert list[1]==2
	
	//each means for each item in a list or map
	[2,-17,+987,0].each {
		println it
	}
	
	// specify a list as 'range', by only the first and last items, why range is () not []
	// range is define use .. or ..< , [3..7] means [(3..7)] 
	
	def r=4..8
	r.each {println it}
	(3..7).each{println it}
	
	// Data Convert using the keyword 'as'
	
	assert ('100' as Integer)==100
	
	def x = ['97', '98', '99'] as Integer[] //convert each item in list to an Integer
	assert x[0] == 97 && x[1] == 98 && x[2] == 99 //access each element individually
	
	// GString have to be used inside double quotes
	10.times{ println "* $it"}
	10.times{ println '* $it'}
	
	