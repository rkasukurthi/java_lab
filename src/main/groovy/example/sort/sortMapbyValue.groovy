package example.sort

/**
 * what's the <=> mean? 
 * <=> spacesship operator, original from Perl
 * 
 * examples: 
 * 
 * a= (5 <=> 7);  # $a is set to -1
 * a = (7 <=> 5);  # $a is set to 1
 * 6 <=> 6;  # $a is set to 0
 * 
 * @see http://stackoverflow.com/questions/12574669/groovy-sort-with-comparator-syntax
 * @author zluo
 *
 */

def map=[a:1, b:5, c:4]

def map1 =map.sort{a,b -> a.value <=> b.value}
println map1.toMapString()


def map2 =map.sort{it.value}
println map2.toMapString()

//descending
def map3 =map.sort{-it.value}
println map3.toMapString()


assert -1 == (5 <=> 7)
assert 1 == (7 <=>5)
assert 0==(6 <=>6)
