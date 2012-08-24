package example.category
/**
 * The document is located in  : 
 * {@link http://groovy.codehaus.org/Category+and+Mixin+transformations}
 * 
 * 
 * @author zluo
 *
 */

final class Distance {
    def number
    String toString() { "${number}m" }
}

class NumberCategory {
    static Distance getMeters(Number self) {
        new Distance(number: self)
    }
}

use(NumberCategory) {
    def dist = 300.meters

    assert dist instanceof Distance
    assert dist.toString() == "300m"
}

/**
 *  Demostrate @Category and @Mixin
 */

@Category(Vehicle) class FlyingAbility {
    def fly() { "I'm the ${name} and I fly!" }
}

@Category(Vehicle) class DivingAbility {
    def dive() { "I'm the ${name} and I dive!" }
}

interface Vehicle {
    String getName()
}

@Mixin(DivingAbility)
class Submarine implements Vehicle {
    String getName() { "Yellow Submarine" }
}

@Mixin(FlyingAbility)
class Plane implements Vehicle {
    String getName() { "Concorde" }
}

@Mixin([DivingAbility, FlyingAbility])
class JamesBondVehicle implements Vehicle {
    String getName() { "James Bond's vehicle" }
}
 
assert new Plane().fly() ==
       "I'm the Concorde and I fly!"
assert new Submarine().dive() ==
       "I'm the Yellow Submarine and I dive!"

assert new JamesBondVehicle().fly() ==
       "I'm the James Bond's vehicle and I fly!"
assert new JamesBondVehicle().dive() ==
       "I'm the James Bond's vehicle and I dive!"





















