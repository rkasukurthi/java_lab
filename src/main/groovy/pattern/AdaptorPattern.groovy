package pattern

class SquarePeg {
	def width
}

class RoundPeg{
	def radius
}

class RoundHole{
	def radius
	def pegFits(peg)
	{
		peg.radius <=radius
	}
	String toString() {"RoundHole with radius $radius"}
}

// delegate Adaptor

class SquarePegAdapter {
	def peg
	def getRadius()
	{
	    Math.sqrt(((peg.width/2) ** 2)*2)
	}
	String toString() {
		"SquarePegAdapter with peg width $peg.width (and notional radius $radius)"
	}
}

def hole=new RoundHole(radius:4.0)
(4..7).each{ w ->
	 def peg = new SquarePegAdapter(peg:new SquarePeg(width:w))
    if (hole.pegFits(peg))
        println "peg $peg fits in hole $hole"
    else
        println "peg $peg does not fit in hole $hole"
}

