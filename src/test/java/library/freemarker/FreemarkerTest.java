package library.freemarker;

import com.alibaba.fastjson.JSON;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;

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
        File viewDir = new File(Class.class.getResource("/").getPath() + "/ftl");
        render(viewDir, viewDir.list());
    }

    public void render(File viewDir, String... files) {
        try {
            Configuration conf = new Configuration();
            conf.setDirectoryForTemplateLoading(viewDir);
            Writer writer = new PrintWriter(System.out);
            for (String file : files) {
                conf.getTemplate(file).process(new HashMap<String, Object>(), writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
