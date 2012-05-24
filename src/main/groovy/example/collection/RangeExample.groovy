package example.collection


(1..10).each{println "Hello $it"}



// range can be used in switch statements
def years
def interestRate

switch(years)
{
	case 1..10: interestRate=0.076; break;
	case 11..25: interestRate=0.052; break;
	default: interestRate=0.037;
}	