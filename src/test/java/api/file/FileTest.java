package api.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Murphy on 1/16/2015.
 *
 * Test case about Thinking in Java
 */
public class FileTest {

    private final Logger log = LogManager.getLogger(this.getClass());

    /*private*/ static final String SYSTEM_TEMP_DIRECTORY_PATH = "java.io.tmpdir";

    private final static String RESOURCE_DIR = Class.class.getResource("/").getPath() + "/ftl";

    @Test
    public void testReadByText() throws IOException{
        File ftl = new File(RESOURCE_DIR + "/a.ftl");
        if (!ftl.exists()) {
            return;
        }
        log.info(ftl.getCanonicalPath());
        log.info(ftl.getAbsolutePath());
    }

}
