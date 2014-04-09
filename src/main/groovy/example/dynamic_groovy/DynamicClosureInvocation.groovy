package example.dynamic_groovy

def c = { it1->
	return "$it1,I'm a clousre, named c, $it1"
}
// call closure with the variable
println "${c('Hello')} , ok"

def c1 = { it1->
	  println "directly call closure, $it1,I'm a clousre, named c, $it1"
}

c1 'c1'

/**
 * call a closure from string
 */
def string ="{it -> println it}"
def sh=evaluate(string)
sh(1)

sh 2

sh 'dddd'