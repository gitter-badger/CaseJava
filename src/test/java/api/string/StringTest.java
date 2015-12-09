package api.string;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by luohao4 on 2015/8/19.
 */
public class StringTest {

    @Test
    public void test() {
        String  a = "1",
                b = "1",
                c = new String("1"),
                d = a;

        assertTrue(a == b);
        assertFalse(a == c);
        assertFalse(b == c);
        assertFalse(d == c);

        /***
         * @See java.lang.String#intern()
         * ===================================
         * Returns a canonical representation for the string object.
         * -----------------------------------
         * canonical representation：标准表示，典型的表示（典式）
         * -----------------------------------
         * 返回String对象的引用的真实值？(TODO CHECK)
         */
        assertTrue(a.intern() == c.intern());
        assertTrue(c.intern() == d.intern());
    }

    @Test
    public void testRegEx() {
        Pattern reg = Pattern.compile("^-?\\d$");
        System.out.println(reg.matcher("-1").find());
        Pattern jsonPattern = Pattern.compile("^\\{\\S\\}");
        System.out.println(jsonPattern.matcher("{\"a\": 1}").find());
    }

    public void testStringJoinWithPlus(int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            doNothing(i + ":join-plus-" + System.currentTimeMillis());
        }
        System.out.print("join-plus\t\t");
        System.out.println(System.currentTimeMillis() - start);
    }

    public void testStringJoinWithFormat(int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            doNothing(String.format("%d:join-format-%d", i, System.currentTimeMillis()));
        }
        System.out.print("join-format\t\t");
        System.out.println(System.currentTimeMillis() - start);
    }

    public void testStringJoinWithBuffer(int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            doNothing(new StringBuffer(i).append(":join-format-").append(System.currentTimeMillis()).toString());
        }
        System.out.print("join-buffer\t\t");
        System.out.println(System.currentTimeMillis() - start);
    }

    void doNothing(String s){}

    @Test
    public void testJoinStringAll() {
        testStringJoinWithFormat(10);
        testStringJoinWithPlus(10);
        testStringJoinWithBuffer(10);
        testStringJoinWithFormat(1000);
        testStringJoinWithPlus(1000);
        testStringJoinWithBuffer(1000);
        testStringJoinWithFormat(100000);
        testStringJoinWithPlus(100000);
        testStringJoinWithBuffer(100000);
        /*testStringJoinWithFormat(10000000);
        testStringJoinWithPlus(10000000);
        testStringJoinWithBuffer(10000000);*/
    }

}
