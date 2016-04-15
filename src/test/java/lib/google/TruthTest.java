package lib.google;

import static com.google.common.truth.Truth.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luohao4 handle 2016/1/22.
 */
public class TruthTest {

    Logger log = LogManager.getLogger(this.getClass());

    @Test
    public void testAssertThat() {
        try {
            assertThat(false).isTrue();
        } catch (Error e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void testIsEquals() {
        try {
            assertThat(1).isEqualTo(5);
        } catch (Error e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void testContains() {
        Set<Integer> sets = new HashSet<Integer>(){{
            this.add(1);
            this.add(2);
            this.add(3);
        }};
        assertThat(sets).contains(1);
        assertThat(sets).containsAllOf(1, 2);
        assertThat(sets).containsNoneOf(4, 5, 6);
        assertThat(sets).containsAnyOf(1, 3, 5, 7);
    }

}
