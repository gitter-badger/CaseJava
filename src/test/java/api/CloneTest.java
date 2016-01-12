package api;

import org.junit.Test;

/**
 * Created by luohao4 on 2016/1/12.
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
            System.out.println(a1.b.a);
            b.a = 2;
            System.out.println(a1.b.a);
            System.out.println(a1.b.b);
            b.b = "as";
            System.out.println(a1.b.b);
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
