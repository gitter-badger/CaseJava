package biz;

import org.junit.Before;
import org.junit.Test;
import us.cijian.model.Queen;

/**
 * Created by Murphy handle 4/6/2015.
 */
public class QueenTest {

    private Queen<String> queen;

    @Before
    public void before(){
        queen = new Queen<String>();
    }

    @Test
    public void testQueen() {
        queen.push("a");
        queen.push("b");
        queen.push("c");
        queen.push("d");

    }


}
