package lib.google;

import static com.google.common.truth.Truth.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by luohao4 on 2016/1/22.
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
    
    
}
