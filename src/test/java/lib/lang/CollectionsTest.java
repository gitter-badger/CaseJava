package lib.lang;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohao4 handle 2015/7/8.
 */
public class CollectionsTest {

    @Test
    public void testFilter() {
        List<Integer> items = new ArrayList<Integer>(){{
            this.add(0);
            this.add(1);
            this.add(2);
            this.add(4);
            this.add(6);
            this.add(7);
            this.add(8);
            this.add(9);
        }};
        CollectionUtils.filter(items, new Predicate<Integer>() {
            public boolean evaluate(Integer i) {
                return i > 4;
            }
        });
        for (Integer item : items) {
            Assert.assertTrue("大于 4", item > 4);
        }
    }

}
