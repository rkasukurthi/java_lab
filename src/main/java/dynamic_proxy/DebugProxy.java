package dynamic_proxy;
/**
 * 
 * java.lang.reflect.Proxy class and
 * java.lang.refelect.InvocationHandler make up the heart of Dynamic Proxy's 
 * functionality.
 * 
 * Example of Dynamic Proxy Class, kind of implements AOP.
 * 
 * The class that can acheive the dynamic proxy, must be implement the interface base.
 * 
 * Proxy classes are created using the static methods of the class java.lang.reflect.Proxy.
 * 
 * see this IBM tutorial
 * http://www.ibm.com/developerworks/java/library/j-jtp08305/index.html
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DebugProxy implements java.lang.reflect.InvocationHandler {

	private Object obj;
	
	public static Object newInstance(Object obj)
	{
		return java.lang.reflect.Proxy.newProxyInstance(
				obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(),
				new DebugProxy(obj));
	}
	
	private DebugProxy(Object obj)
	{
		this.obj=obj;
	}
	
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {

		Object result;
		try {
			System.out.println("before method " + m.getName());
			result=m.invoke(obj,args);
		}
		catch (InvocationTargetException e)
		{
			throw e.getTargetException();
		}
		catch (Exception e)
		{
			throw new RuntimeException("upexpected invocation exception: " + e.getMessage());
		}
		finally
		{
			System.out.println("after method " + m.getName());
		}
		return result;
	}

	
	
	public static void main(String[] args)
	{
		Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
	    Object obj= foo.bar(null);
	}
	
	
	
	
	
	
	
}
