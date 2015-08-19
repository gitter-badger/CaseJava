package api.string;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
