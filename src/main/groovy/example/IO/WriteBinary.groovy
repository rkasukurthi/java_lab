package example.IO

    byte[] contents
	def fos=new FileOutputStream("c:/temp/a.pdf")
	contents.each {fos.write(it)}
	fos.close()
