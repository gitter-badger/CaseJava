package jdk;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohao4 on 2016/1/7.
 */
public class Generics {


    /**
     * 测试绕过泛型
     */
    @Test
    public void testIgnore() {
        List<String> list = new ArrayList<String>();
        list.add("");
        Class clazz = list.getClass();
        try {
            Method add = clazz.getDeclaredMethod("add", Object.class);
            add.invoke(list, 1);
            add.invoke(list, true);
            System.out.println(list.get(1) instanceof String);
            System.out.println(list.get(2) instanceof String);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
