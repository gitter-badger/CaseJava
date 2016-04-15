package lib.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Created by murphyl handle 12/18/14.
 */
public class JsoupTest {


    @Test
    public void testJsoupGetDocument() throws IOException {
        Document doc = Jsoup.connect("http://www.google.com").get();
        System.out.println(doc.getAllElements());
    }


    /***
     * 修复富文本 HTML 代码的思路
     * 1. 使用 Jsoup 解析 HTML 代码片段，将会出现一个修正过的版本；
     * 2. 处理掉一些易干扰的标签，如 font、br、hr...
     * 3. 针对性的移除一些不必要的属性。
     */

}
