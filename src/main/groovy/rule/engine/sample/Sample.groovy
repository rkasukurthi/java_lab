package rule.engine.sample
/**
 * Simplely Rule Engine are just conditions and Actions
 * Review at June 9th, 2014
 * 
 * parameters list contains [c1,c2,a1]
 * 
 * Rule engine iterate all conditions, then run action.
 * 
 */

class Developer {
	private String name
	private int experience
	private String level="unknown"
}

def c1= {Developer dev, experience -> dev.experience>experience}
def c2= {Developer dev, experience -> dev.experience < experience}

def a1= {Developer dev, level-> dev.level=level}

def developer = new Developer(name:"Peter", experience:2)

if (c1(developer,1) && c2(developer,3))
{
	a1(developer,"Junior")
}

assert developer.level=="Junior"



/**
 * Define rule, ruleset is the set of rules 
 * 
 * There are three elements inside Rule class, conditions, actions and parameters.
 * 
 * parameters 
 * 
 * @author zluo
 *
 */

class Rule {
	private boolean singlehit=true
	private conditions = new ArrayList()
	private actions = new ArrayList()
	private parameters = new ArrayList()
	
}

class RuleSet{
	private rules = new ArrayList<Rule>()
}


// Implements the Rule Engine

class RuleEngine {
	
	def run (RuleSet ruleset, Object bo) {

		ruleset.rules.each{Rule rule ->
			println "Excuting rule in ${(rule.singlehit?"singlehit":"multihit")} mode."
			def exit =false
			
			rule.parameters{ArrayList params ->
				def pcounter=0
				def success=true
				
				if(!exit) {
					rule.conditions.each {
						success=success && it(bo, params[pcounter])
						pcounter ++
					}
				}
				
				if (success && !exit)
				{
					rule.actions.each{
						it(bo, params[pcounter])
						pcounter++
					}
				}
				
				if (rule.singlehit)
				{
					exit=true
				}
				
			}
		}
	}
}
	
	def addRule(RuleSet ruleset)
	{
		def rule = new Rule()
		
		//********************CONFIGURATION******************
		rule.singlehit=false
		
		//********************CONDIITONS*********************
		rule.conditions=[{Developer bo,p-> bo.experience >p },{Developer bo, p -> bo.experience <=p}]
		
		//********************ACTIONS************************
		rule.actions=[ {Developer bo,p -> bo.level=p}]
		
		//********************PARAMETERS*********************
		rule.parameters=[
			[1,3,'Beginner'],
			[4,6,'Junior'],
			[7,10,'Average'],
			[11,20,'Senior'],
			]
		
		ruleset.rules<<rule
	}
	
	
	def dev = new Developer(name:"Peter", experience:10)
	println "Before: ${dev.dump()}"
	
	def ruleset = new RuleSet()
	addRule (ruleset)
	
	def engine = new RuleEngine()
	engine.run(ruleset, dev)
	
	println "After: ${dev.dump()}"
	
	
	
	
	
	
	
	

































