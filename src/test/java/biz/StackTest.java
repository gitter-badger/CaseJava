package biz;

import org.junit.Before;
import org.junit.Test;
import us.cijian.model.Stack;

/**
 * Created by Murphy on 4/6/2015.
 */
public class StackTest {

    private Stack<String> stack;

    @Before
    public void before() {
        stack = new Stack<String>();
    }

    @Test
    public void test() {
        stack.push("c");
        stack.push("1");
        stack.push("b");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }

}
