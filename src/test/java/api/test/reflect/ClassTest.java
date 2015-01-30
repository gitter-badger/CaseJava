package api.test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassTest {

    Class<? extends ClassTest> currentClass = this.getClass();

    @Test
    public void testGetClassName() {
        // 获取对象所在的类的名称
        System.out.println(ClassTest.class.getName());
    }

    @Test
    public void testGetClassMethod() {
        ClassTest ct = new ClassTest();
        // 获取　Package
        System.out.println(ct.getClass().getPackage().getName());
        // 获取所有方法，包括从父类继承下来的。obj.getDeclaredMethods()　只获取自身的方法
        Method[] ms = ct.getClass().getMethods();
        for (Method m : ms) {
            // 获取方法所在类的包名
            String pk = m.getDeclaringClass().getPackage().getName();
            if (pk.equals("java.lang")) {
                System.out.print("# ");
            } else {
                System.out.print("* ");
            }
            // 还原修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "　");
            // 获取返回值类型
            String returnType = m.getReturnType().getCanonicalName();
            // 获取方法名称
            System.out.print(returnType + " " + m.getName());
            // 获取方法的所有参数
            System.out.print("(");
            Class<?>[] ps = m.getParameterTypes();
            for (int i = 0; i < ps.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(ps[i].getCanonicalName() + " arg" + i);
            }
            System.out.print(")");
            // 获取异常定义
            Class<?>[] exs = m.getExceptionTypes();
            if (exs.length > 0) {
                System.out.print(" throws ");
                for (int i = 0; i < exs.length; i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    // 获取异常的名称
                    System.out.print(exs[i].getSimpleName());
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testGetMethodSupport() {
        Method[] ms = Method.class.getDeclaredMethods();
        for (Method m : ms) {
            System.out.println(Modifier.toString(m.getModifiers()) + "　" + m.getReturnType().getSimpleName() + " " + m.getName());
        }
    }

    @Test
    public void testGetAnnotation() throws SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        try {
            Double jvm = Double.valueOf(System.getProperty("java.specification.version"));
            Class<?> clazz = Class.class;
            Method method;
            if (jvm < 1.8) {
                method = clazz.getDeclaredMethod("getAnnotation", clazz);
            } else {
                method = clazz.getDeclaredMethod("getDeclaredAnnotation", clazz);
            }
            System.out.printf("JDK %s 支持方法 %s.%s()\n", jvm, method.getClass().getName(), method.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    @Before
    public void beforeTest() {
        System.out.println("----------------------");
    }

    @After
    public void afterTest() {
        System.out.println("----------------------");
    }

}
