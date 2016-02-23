package lib.freemarker;

import freemarker.template.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by murphyl on 12/11/14.
 */
public class FreemarkerTest {


    @Before
    public void before() {
        System.out.println("\nFreemarker result start ====>");
    }

    @After
    public void after() {
        System.out.println("\nFreemarker result end ====>");
    }

    @Test
    public void test() throws IOException {
        String tpl = getClass().getResource("/").getPath() + "/ftl";
        File viewDir = new File(tpl);
        render(viewDir, viewDir.list());
    }

    public void render(File viewDir, String... files) {
        try {
            Configuration conf = new Configuration();
            conf.setDirectoryForTemplateLoading(viewDir);
            Writer writer = new PrintWriter(System.out);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("name", "MurphyL");
            params.put("array", new String[]{"a", "b", "c"});
            for (String file : files) {
                System.out.printf("\n%s-------------------\n", file);
                conf.getTemplate(file).process(params, writer);
                System.out.printf("\n%s-------------------\n\n", file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
