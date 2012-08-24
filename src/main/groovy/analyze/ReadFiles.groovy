package analyze

/**
 * Sample line
 * INFO: <-- ChainCommand finished in : b9d0494e-4535-4b12-8676-967cab9bc4f0 923(ms)
 * INFO: 1332613205985 [ba] leaving OnlineController.displayPage: 97 ms 
 * INFO: 1332613205964 [ba] leaving SetAttributeAction.complete: 0 ms
 * INFO: 1332613205954 [ba] leaving OnlineController.generateIntermediateFromTemplateBytes.synchronized: 47 ms
 * INFO: 1332613205954 [ba] leaving OnlineController.displayPage.generateIntermediate: 47 ms
 * INFO: 1332613205996 [ba] leaving AwsSOAPBindingImpl.handleSessionEvent: 134 ms
 * INFO: 1332613206247 [af] guid='z2aFkOWlwIULZCsmwUTLfCm4CdE='
 * @author zluo
 *
 */

def patterns =[
	/^INFO: (\d*) \[(.+)\] leaving (.+?): (\d*) ms/
]

def matcher

new File("c:/temp/out_0.log").eachLine {

	patterns.each{pattern ->
		matcher= it=~pattern
		if (matcher.find()) {
			println matcher[0]
		}
	}
}

