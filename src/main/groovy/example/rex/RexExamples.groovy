package example.rex

import java.util.regex.Pattern

/*
 *  ~"pattern"
 *  =~
 *  ==~
 */

// ~ creates a Pattern from String

def pattern = ~/foo/
assert pattern instanceof Pattern
assert pattern.matcher("foo").matches()
//assert pattern.matcher("foobar").matches() //returns FALSE



assert "How tall is Angelina Jolie?" ==~ /[^\?]+\?/

// Although matcher isn't a list, it can be indexed like a list.
def matcher = "eat green cheese" =~ /e+/
assert "ee" == matcher[2]
assert ["e","ee","ee"] == matcher[0..2]

matcher ="cheese please"=~/([^e]+)e+/

assert [["chee","ch"],["se","s"],[" ple"," pl"],["ase","as"]]==matcher[0..3]

// Matcher defines an iterator() method, so it can be used, for example collect() and each():

matcher ="cheese please" =~ /([^e]+)e+/
matcher.each{println it}
matcher.reset()
assert matcher.collect { it } == [["chee", "ch"], ["se", "s"], [" ple", " pl"], ["ase", "as"]]

// there is also regular expression aware iterator grep()

assert ["foo", "moo"] ==["foo", "bar", "moo"].grep(~/.*oo$/)

//which can be written also with findAll() method
assert ["foo","moo"]==["foo", "bar", "moo"].findAll{it==~/.*oo/}


/**
 * More Examples, Capitalize words at the beginning of each line
 */

def before='''
apple
orange
y
banana
'''

def expected='''
Apple
Orange
Y
Banana
'''









