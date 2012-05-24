package example.embedding;

import groovy.lang.Binding;
import groovy.lang.Script;


/**
 * This class demonstrate the call a groovy script from java	
 * 
 * Embed Groovy script inside Java by using GroovyScriptEngine
 * @author zluo
 *
 */
public class JavaCaller {
	
	public static void main(String[] args)
	
	{
	   	Binding binding = new Binding();
	   	binding.setVariable("cheese", "Cheddar");
        binding.setVariable("args", args);	   	
	   	Script basicScript = new BasicScript(binding);
	   	basicScript.run();
	   	
	}

	
	
}
