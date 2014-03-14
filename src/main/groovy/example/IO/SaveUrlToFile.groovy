def url = "http://www.google.com/finance/getprices?i=60&p=1d&f=d,o,h,l,c,v&df=cpct&q=AMD" 
def file = new File('c:/temp/amd.txt').newOutputStream()  
file << new URL(url).getText()
file.close()  