package example.closure.currying

/**
 * In this example, call a closure need two parameters, but one parameter are in common,
 * So you can define an new closure simply reduce one parameter.
 * 
 */

def tellFortunes(Closure closure){
  
  Date date= new Date()
  
  closure date, "You day is filled with ceremony"
  closure date, "They're features, not bugs"
 
  Closure postFortune = closure.curry(date)
  
  postFortune "I like you"
  postFortune "Call me"
   
}

Closure c={ date, fortune ->
 println "Fortune for ${date} is '${fortune}'"
}


tellFortunes(c)