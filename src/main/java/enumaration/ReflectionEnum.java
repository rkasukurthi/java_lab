package enumaration;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explore {
	HERE, THERE
}
/**
 * values() is a static method added by compiler.
 * there is also a valueOf() method added by compiler.
 * run javap xxxEnum, you will see the enumeration is just a normal class. 
 * another good thing is the enumeration support switch, (Do not include .class)
 *
 */
public class ReflectionEnum {

	public static Set<String> analyze(Class<?> enumClass) {
		print("------Analyzing  " + enumClass + " ------");
		print("Interfaces:");
		for(Type t: enumClass.getGenericInterfaces())
		{
		  print(t);	
		}
		
		print("Base: " + enumClass.getSuperclass());
		
		print("Methods: ");
		Set<String> methods = new TreeSet<String>();
		for(Method m: enumClass.getMethods())
		{
			methods.add(m.getName());
		}
		
		print(methods);
		
		return methods;
	}

	static private void print(Object aText) {
		System.out.println(String.valueOf(aText));
	}
	
	public static void main(String[] args) throws IOException
	{
		Set<String> exploreMethods = analyze(Explore.class);
		Set<String> enumMethods = analyze(Enum.class);
		exploreMethods.removeAll(enumMethods);
		print("Explore.removeAll(Enum):");
		print(exploreMethods);
		print(Runtime.getRuntime().exec("javap Explore"));
	}
	
}
