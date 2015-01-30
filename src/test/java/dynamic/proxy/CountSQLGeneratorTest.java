package dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import us.cijian.dynamic.proxy.Count;
import us.cijian.dynamic.proxy.CountInvocationHandler;
import us.cijian.dynamic.proxy.Query;

public class CountSQLGeneratorTest {

	@Test
	public void create() {
		Query query = new Count();
		Class<?> queryClass = query.getClass();
		InvocationHandler handler = new CountInvocationHandler(query);
		Query count = (Query)Proxy.newProxyInstance(queryClass.getClassLoader(), queryClass.getInterfaces(), handler);
		count.doSelect();
		System.out.println(count);
	}

}
