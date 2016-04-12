package jdk;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MurphyL
 */
public class CloneTest {

    @Test
    public void test() {
        A a = new A();
        a.a = 1;
        B b = new B(a.a, "2");
        a.b = b;
        try {
            A a1 = (A) a.clone();
            Assert.assertEquals(a1.b.a, a.a);
            b.a = 2;
            Assert.assertEquals(a1.b.a, b.a);
            b.b = "as";
            Assert.assertSame(a1.b.b, b.b);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public class A implements Cloneable {
        Integer a;
        B b;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public class B implements Cloneable {
        Integer a;
        String b;

        public B(Integer a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}
