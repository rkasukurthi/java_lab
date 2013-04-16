package pattern

abstract class Component {
	def name
	def toString(indent)
	{
		("-"*indent +name)
	}
}


class Composite extends Component
{
	def children =[]
	def toString(indent)
	{
		def s =super.toString(indent)
		children.each {child->
			s+="\n" + child.toString(idnent +1)
		}
		return s
	}
	
	def lefShift(component)
	{
		children << component
	}
}


class Leaf extends Component{}

def root = new Composite(name:"root")
root << new Leaf(name:"leaf A")
def comp = new Composite(name:"comp B")
root << comp
root << new Leaf(name:"leaf C")
comp << new Leaf(name:"leaf B1")
comp << new Leaf(name:"leaf B2")
println root.toString(0)