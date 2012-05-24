package example.collection


/**
 * The document located in 
 * http://groovy.codehaus.org/Collections
 */
def arr=[1,2,3,4]

square={it*it}

arr.each(square)

arr.each{println it}

// Getting efficient with the star-dot '*.' operator
assert [1, 3, 5] == ['a', 'few', 'words']*.size()


// Enhanced Collection Methods
def words = ['ant', 'buffalo', 'cat', 'dinosaur']
assert words.findAll{ it.size() > 4 } == ['buffalo', 'dinosaur']

//collect means collect the result
assert words.collect{ it[0] } == ['a', 'b', 'c', 'd']

words.each{ println it[0] }

//Slicing with the subscript operator

def text = "nice cheese gromit!"
def x = text[2]

assert x == "c"
assert x.class == String

def sub = text[5..10]
assert sub == 'cheese'

def map = [name:"Gromit", likes:"cheese", id:1234]

assert map["name"] == "Gromit"
assert map.name == "Gromit"

def list = [10, 11, 12]
def answer = list[2]
assert answer == 12

//negative indices to count from the end of the List, array, String etc.
def text2 = "nice cheese gromit!"
def x2 = text[-1]
assert x2 == "!"

def name = text[-7..-2]
assert name == "gromit"


// backwards range
def text1 = "nice cheese gromit!"
def name1 = text[3..1]
assert name1 == "eci"


//Dynamic objects (Expandos)

def player = new Expando()
player.name = "Dierk"
player.greeting = { "Hello, my name is $name" }

println player.greeting()
player.name = "Jochen"
println player.greeting()




