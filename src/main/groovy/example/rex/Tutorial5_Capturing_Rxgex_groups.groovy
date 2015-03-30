package example.rex

locationData = "Liverpool, England: 53d 25m 0s N 3d 0m 0s"

// define a regular express
myRegularExpression = /([a-zA-Z]+), ([a-zA-Z]+): ([0-9]+). ([0-9]+). ([0-9]+). ([A-Z]) ([0-9]+). ([0-9]+). ([0-9]+)./

// define a matcher
matcher= (locationData =~ myRegularExpression)

println matcher[0]

if (matcher.matches()) {
	println(matcher.getCount()+ " occurrence of the regular expression was found in the string.");
	println(matcher[0][1] + " is in the " + matcher[0][6] + " hemisphere. (According to: " + matcher[0][0] + ")")
}


// Non-matching Groups

names = [
    "Graham James Edward Miller",
    "Andrew Gregory Macintyre",
    "No MiddleName"
]

printClosure = {
	if (matcher.matches())

	matcher = (it =~ /(.*?)(?: .*)* (.*)/);  // notice the non-matching group in the middle
	println(matcher[0])
		println(matcher[0][2]+", "+matcher[0][1]);
}
names.each(printClosure);

println ("---------------------------")
matcher =('May.1998' =~ /[0-9]++/)
matcher.each{println it}

def email=''' 
To: elvis@hh.tabloid.org (The King)
From: jfriedl@regex.info (Jeffrey Friedl)
Subject: Re: Be seein' ya around
On Thu, Feb 29 2007 11:15 The King wrote:
|> Sorry I haven't been around lately. A few years back I checked
|> into that ole heartbreak hotel in the sky, ifyaknowwhatImean.
|> The Duke says "hi".
|> Elvis
'''
matcher =(email =~ /Subject:.(.*)/)
matcher.each{println it}

println ("----------Copyright 2003-- Greedy---------------")
matcher =('Copyright 2003' =~ /^.*([0-9]+)/)
matcher.each{println it}

println ("----------Copyright 2003--Reluctant--------------")
matcher =('Copyright 2003' =~ /^.*?([0-9]+)/)
matcher.each{println it}


