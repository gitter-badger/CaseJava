package api.test.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.After;
import org.junit.Test;

public class ClassTest {

	@Test
	public void testGetClassName() {
		System.out.println(ClassTest.class.getName());
	}

	@Test
	public void testGetClassMethod() {
		ClassTest ct = new ClassTest();
		Method[] ms = ct.getClass().getMethods();
		for (Method m : ms) {
			String pk = m.getDeclaringClass().getPackage().getName();
			if(pk.equals("java.lang")){
				System.out.print("# ");
			} else {
				System.out.print("* ");
			}
			String retirnType = m.getReturnType().getCanonicalName();
			System.out.print(retirnType + " " + m.getName());
			Parameter[] ps = m.getParameters();
			System.out.print("(");
			if(ps.length > 0){
				for (int i = 0;i < ps.length; i++) {
					if(i > 0){
						System.out.print(", ");
					}
					Parameter p = ps[i];
					System.out.print(p.getType().getSimpleName() + " " + p.getName());
				}
			}
			System.out.print(")");
			Class<?>[] exs = m.getExceptionTypes();
			if(exs.length > 0){
				System.out.print(" throws ");
				for (int i = 0; i < exs.length; i++) {
					if(i > 0){
						System.out.print(", ");
					}
					System.out.print(exs[i].getSimpleName());
				}
			}
			System.out.println();
		}
		ct.getClass().getMethods();
	}
	
	@After
	public void afterTest(){
		System.out.println("----------------------");
	}

}
