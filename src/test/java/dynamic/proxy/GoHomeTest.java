package dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import us.cijian.dynamic.proxy.CarProxy;
import us.cijian.dynamic.proxy.GoHome;
import us.cijian.dynamic.proxy.GoHomeProxy;

public class GoHomeTest {
	/**
	 * 创建类的实例的时候，选择性的初始化该实例。同时可以根据一些特定的配置完成实例对象的初始化。
	 */
	@Test
	public void newInstance() {
		CarProxy driveCar = new CarProxy();
		Class<?> cl = driveCar.getClass();
		InvocationHandler handler = new GoHomeProxy(driveCar);
		GoHome way = (GoHome)Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), handler);
		System.out.println(way.drive());
	}

}
