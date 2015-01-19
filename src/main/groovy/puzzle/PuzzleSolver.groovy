package puzzle

/** build dictionary **/
Set dic= new HashSet()
new File("C:/Users/zluo/git/java_lab/src/main/groovy/puzzle/ew.txt").eachLine{dic.add(it)}

//dic.each {println it}

/** build puzzle **/
def puzzle =['XCUALOVEYKBWSNG',
			 'DUAWKCBEAUTYRJV',
			 'YOUTHFSMGNEZLPR',
			 'MHJREYWDKZLUSTJ',
			 'FSUCCESSDHEALTH',
			 'ENMQXPTIMELMSAQ',
			 'VEXPERIENGEGHBW',
			 'GHUMOURLOYMONEY',
			 'SYZPOPULARITYNA',
			 'AMKCFUNBXHUZYIX',
			 'CWIHYSHAPPINESS',
			 'HONESTYCFRIENDS',
			 'KPYJAETWPOWERQC',
			 'BTYACFREEDOMJMO',
			 'RIWINTELLIGENCE']

puzzle.each{String row -> 
	
	def it=row.toLowerCase()
//	println it
	for (int i=0; i < it.size()-1; i++){
		for(int j=4;j<it.size()-i+1; j++){
			def word =it.substring(i, i+j)
//			println "$i:${i+j}:$word"
			
			if (dic.contains(word)){
//				println "==================="
				println word
//				println "==================="
			}
		}
	}
	
}
