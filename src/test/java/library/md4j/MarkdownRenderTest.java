package library.md4j;

import org.junit.Test;
import org.markdown4j.Markdown4jProcessor;

import java.io.IOException;

/**
 * Created by luohao4 on 2015/6/18.
 */
public class MarkdownRenderTest {


    @Test
    public void testRender (){
        try {
            System.out.println(new Markdown4jProcessor().process("# 11"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
