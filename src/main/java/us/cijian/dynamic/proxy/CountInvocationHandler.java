package us.cijian.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CountInvocationHandler implements InvocationHandler {
	
	private Query query;
	
	public CountInvocationHandler(Query query) {
		this.query = query;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(query, args);
	}

}
