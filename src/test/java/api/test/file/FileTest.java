package api.test.file;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Murphy on 1/16/2015.
 */
public class FileTest {

    String dir = Class.class.getResource("/").getPath() + "/ftl";

    @Test
    public void testReadByText() throws IOException{
        File ftl = new File(dir + "/a.ftl");
        if (ftl.exists()) {
            return;
        }
        FileReader reader = new FileReader(ftl);
        PrintWriter writer = new PrintWriter(System.out);

        writer.write(reader.read());
    }

}
