package example.IO
/**
 * This example demostrate how to write 
 */


public void writeToFile(def directory, def fileName, def extension, def infoList) {
	new File("$directory/$fileName$extension").withWriter { out ->
		infoList.each { out.println it }
	}
}

def createFolder()
{
	
}

def dirver = 'C:/'
def folderName = 'testFolder'
def c

def txtFileInfo = []

String a = "Today is a new day"
String b = "Tomorrow is the future"
String d = "Yesterday is the past"

txtFileInfo << a
txtFileInfo << b
txtFileInfo << d

c = createFolder(dirver, folderName) //this simply creates a folder to drop the txt file in

writeToFile(c, "garbage", ".txt", txtFileInfo)



