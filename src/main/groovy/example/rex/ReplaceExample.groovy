package example.rex

/**
 * This example show how to use backreferences with String.replaceAll.
 */
def replaced ="abc".replaceAll(/(a)(b)(c)/, 'After replace: $1$3')
println replaced

def formatedNumber='1234567890'.replaceAll(/(\d{3})(\d{3})(\d{4})/, '($1)$2-$3')
println formatedNumber

def before='''
apple is sweet
orange
y
banana
''' 

def c= {it -> it[0].toUpperCase() + (it.size()>1 ? it[1..-1]:'') }

println before.replaceAll(/(?m)^\w+/, c)


println "it is a Beautiful Day!".replaceAll(/\w+/, c)