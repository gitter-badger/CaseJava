package lib.freemarker;

import freemarker.template.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by murphyl on 12/11/14.
 */
public class FreemarkerTest {

    Logger log = LogManager.getLogger(this.getClass());

    @Test
    public void testByFile() throws IOException {
        String tpl = getClass().getResource("/").getPath() + "/ftl";
        File viewDir = new File(tpl);
        renderFile(viewDir, viewDir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return ! name.startsWith("_");
            }
        }));
    }

    public void renderFile(File viewDir, String... files) {
        try {
            Configuration conf = new Configuration();
            conf.setDirectoryForTemplateLoading(viewDir);

            Writer writer = new PrintWriter(System.out);
            Map<String, Object> params = new HashMap<String, Object>();
            for (String file : files) {
                log.debug(file);
                conf.getTemplate(file).process(params, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
