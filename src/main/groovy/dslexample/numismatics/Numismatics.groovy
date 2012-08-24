package dslexample.numismatics
// import static
import static Coin.*
import static CoinValues.*
/**
* Define Coin enum
*
*/

enum Coin {
	penny(1), 
	nickel(5),
	dime(10),
	quarter(25)
	
	int value
	Coin(int value)
	{ this.value = value }
}

// directly use the values
assert 4 * quarter.value + 4 * nickel.value + 3 * penny.value == 123

// override values
class CoinValues {
	static get(Integer self, String name) {
		self * Coin."${singular(name)}".value
	}
	static singular(String val) {
		val.endsWith('ies') ? val[0..-4] + 'y' :
			val.endsWith('s') ? val[0..-2] : val
	}
}

use (CoinValues) {
	assert 2.quarters + 1.nickel + 2.pennies == 57
	assert 2.quarter + 1.nickel + 2.penny == 57
}


Integer.metaClass.getProperty = { String name ->
	def mp = Integer.metaClass.getMetaProperty(name)
	if (mp) return mp.getProperty(delegate)
	def singular = name.endsWith('ies') ? name[0..-4] + 'y' :
			name.endsWith('s') ? name[0..-2] : namegy7uiop[']\
	delegate * Coin."$singular".value
}

assert 2.quarters + 1.nickel + 2.pennies == 57


def process = "ls -l".execute()
println "Found text ${process.text}"
l;[']']
|


