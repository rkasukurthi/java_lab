package example.category

/**
 * The Pimp my Library Pattern suggests an approach for extending a library that nearly does everything that you need but just needs a little more.
 *  It assumes that you do not have source code for the library of interest.

Example
Suppose we want to make use of the built-in Integer facilities in Groovy (which build upon the features already in Java). 
Those libraries have nearly all of the features we want but not quite everything. We may not have all of the source code 
to the Groovy and Java libraries so we can't just change the library. Instead we augment the library.
 Groovy has a number of ways to do this. One way is to use a Category.

First, we'll define a suitable category.

class EnhancedInteger {
    static boolean greaterThanAll(Integer self, Object[] others) {
        greaterThanAll(self, others)
    }
    static boolean greaterThanAll(Integer self, others) {
        others.every{ self > it }
    }
}
We have added two methods which augment the Integer methods by providing the greaterThanAll method. 
Categories follow conventions where they are defined as static methods with a special first parameter representing the class we wish to extend. 
The greaterThanAll(Integer self, others) static method becomes the greaterThanAll(other) instance method.

We defined two versions of greaterThanAll. One which works for collections, ranges etc. 
The other which works with a variable number of Integer arguments.

Here is how you would use the category.

use(EnhancedInteger) {
    assert 4.greaterThanAll(1, 2, 3)
    assert !5.greaterThanAll(2, 4, 6)
    assert 5.greaterThanAll(-4..4)
    assert 5.greaterThanAll([])
    assert !5.greaterThanAll([4, 5])
}
 */


class EnhancedInteger {
    static boolean greaterThanAll(Integer self, Object[] others) {
        greaterThanAll(self, others)
    }
    static boolean greaterThanAll(Integer self, others) {
        others.every{ self > it }
    }
}

