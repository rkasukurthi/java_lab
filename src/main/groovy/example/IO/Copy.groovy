package example.IO

/**
 *  .withWriter 
 *  Creates a new BufferedWriter for this file, passes it to the closure, and ensures the stream is flushed and closed after the closure returns.
 */


// straight copy (not optimally efficient)


new File('c:/new.txt').withWriter { writer ->
	new File('c:/garbage.txt').eachLine { line ->
		writer.writeLine(line)
	}
}


// copy with substitution

new File('c:/new1.txt').withWriter { file ->
	new File('c:/new.txt').eachLine { line ->
		file.writeLine( line.replace('code', 'joy') )
	}
}
