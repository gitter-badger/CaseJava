package jdk.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
import java.lang.reflect.Modifier;
import us.cijian.utils.StringJoiner;

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
        // 获取　Package
        System.out.println(currentClass.getPackage().getName());
        // 获取所有方法，包括从父类继承下来的。obj.getDeclaredMethods()　只获取自身的方法
        Method[] ms = currentClass.getMethods();
        for (Method m : ms) {
            // 获取方法所在类的包名
            String pk = m.getDeclaringClass().getPackage().getName();
            if (pk.equals("java.lang")) {
                continue;
            }
            StringJoiner md = new StringJoiner(" ");
            // 还原修饰符
            md.add(Modifier.toString(m.getModifiers()));
            // 获取返回值类型
            md.add(m.getReturnType().getCanonicalName());
            // 获取方法的所有参数
            Class<?>[] ps = m.getParameterTypes();
            if(ps.length > 0){
                // 获取方法名称
                md.add(m.getName() + "(");
                StringJoiner psa = new StringJoiner(", ");
                for (int i = 0; i < ps.length; i++) {
                    psa.add(ps[i].getCanonicalName() + " arg" + i);
                }
                md.add(psa.toString());
                md.add(")");
            } else {
                md.add(m.getName() + "()");
            }
            // 获取异常定义
            Class<?>[] exs = m.getExceptionTypes();
            if (exs.length > 0) {
                md.add("throws");
                StringJoiner exsa = new StringJoiner(", ");
                for (Class<?> ex : exs) {
                    // 获取异常的名称
                    exsa.add(ex.getSimpleName());
                }
                md.add(exsa.toString());
            }
            System.out.println(md.toString());
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
            Double jdkVersion = Double.valueOf(System.getProperty("java.specification.version"));
            Class<?> clazz = Class.class;
            Method method;
            if (jdkVersion < 1.8 && jdkVersion > 0) {
                method = clazz.getDeclaredMethod("getAnnotation", clazz);
            } else {
                method = clazz.getDeclaredMethod("getDeclaredAnnotation", clazz);
            }
            String className = method.getClass().getName();
            System.out.printf("JDK %s 支持方法 %s.%s()\n", jdkVersion, className, method.getName());
        } catch (Exception e) {
            e.printStackTrace();
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
