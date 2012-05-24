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
assert pattern.matcher("foobar").matches() //returns FALSE



