package lib.test.freemarker;

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

    private static final Configuration _CFG = new Configuration();

    private static final Writer WRITER = new PrintWriter(System.out);

    @BeforeClass
    public static void beforeClass() throws IOException, TemplateException {
        File viewDir = new File(Class.class.getResource("/").getPath() + "/ftl");
        _CFG.setDirectoryForTemplateLoading(viewDir);
    }

    @Before
    public void before() {
        System.out.println("\nFreemarker result start ====>");
    }

    @After
    public void after() {
        System.out.println("\nFreemarker result end ====>");
    }

    @Test
    public void test() throws IOException, TemplateException {
        render("a.ftl");
    }

    public void render(String file) throws IOException, TemplateException {
        _CFG.getTemplate(file).process(new HashMap<String, Object>(), WRITER);
    }


}
