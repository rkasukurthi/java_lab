package example.rex

def checkSpelling(spellingAttempt, spellingRegex)
{
	if (spellingAttempt ==~ spellingRegex)
	{
		println ("Congratulations, you spelled it correctly")
	}
	else
	{
		println("Sorry, try again.")
	}
	
}


theRegularExpression = /Wisn(ie|ei)w?ski/
checkSpelling("Wisniewski", theRegularExpression)
checkSpelling("Wisnieski", theRegularExpression)
checkSpelling("Wisneiski", theRegularExpression)
checkSpelling("WisniewSewski", theRegularExpression)