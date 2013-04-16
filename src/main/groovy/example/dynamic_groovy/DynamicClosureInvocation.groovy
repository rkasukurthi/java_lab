package example.dynamic_groovy

def c = {
	println "I'm a clousre, named c"
}

// call closure directly
c()

// def method name

def method ='c'

// call closure with the variable

println "$method"