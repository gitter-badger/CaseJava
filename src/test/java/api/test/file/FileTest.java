package api.test.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Murphy on 1/16/2015.
 */
public class FileTest {

    private final Logger log = LogManager.getLogger(this.getClass());

    private static final String SYSTEM_TEMP_DIRECTORY_PATH = "java.io.tmpdir";

    String dir = Class.class.getResource("/").getPath() + "/ftl";

    @Test
    public void testReadByText() throws IOException{
        File ftl = new File(dir + "/a.ftl");
        if (!ftl.exists()) {
            return;
        }
        log.info(ftl.getCanonicalPath());
        log.info(ftl.getAbsolutePath());
    }

}
