package us.cijian.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GoHomeProxy implements InvocationHandler {
	
	private GoHome way;
	
	// private String[] a = new String[]{"as"};
	
	public GoHomeProxy(GoHome way) {
		this.way = way;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(way, args);
	}

}
