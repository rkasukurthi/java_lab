package dynamic_proxy;

public class FooImpl implements Foo{

	public Object bar(Object obj) {
		System.out.println("The method bar is called");
		return null;
	}

}
