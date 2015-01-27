package lib.test.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Created by murphyl on 12/18/14.
 */
public class TestJsoup {


    @Test
    public void testJsoupGetDocument() throws IOException {
        Document doc = Jsoup.connect("http://cijian.us/").get();

        System.out.println(doc.getAllElements());
    }

    @Test
    public void testHTMLString() {
        Document doc = Jsoup.parseBodyFragment("<table width=\"100%\" cellpadding=\"4\" cellspacing=\"0\">\n" +
                "    <colgroup>\n" +
                "        <col width=\"128*\"/>\n" +
                "        <col width=\"128*\"/>\n" +
                "    </colgroup>\n" +
                "    <tbody>\n" +
                "        <tr valign=\"TOP\" class=\"firstRow\">\n" +
                "            <td width=\"50%\" style=\"border-top-color: rgb(0, 0, 0); border-bottom-color: rgb(0, 0, 0); border-left-color: rgb(0, 0, 0); border-right-style: none; padding: 0.04in 0in 0.04in 0.04in;\">\n" +
                "                <p>\n" +
                "                    1\n" +
                "                </p>\n" +
                "            </td>\n" +
                "            <td width=\"50%\" style=\"border-color: rgb(0, 0, 0); padding: 0.04in;\">\n" +
                "                <p>\n" +
                "                    2\n" +
                "                </p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr valign=\"TOP\">\n" +
                "            <td width=\"50%\" style=\"border-top-style: none; border-bottom-color: rgb(0, 0, 0); border-left-color: rgb(0, 0, 0); border-right-style: none; padding: 0in 0in 0.04in 0.04in;\">\n" +
                "                <p>\n" +
                "                    3\n" +
                "                </p>\n" +
                "            </td>\n" +
                "            <td width=\"50%\" style=\"border-top-style: none; border-bottom-color: rgb(0, 0, 0); border-left-color: rgb(0, 0, 0); border-right-color: rgb(0, 0, 0); padding: 0in 0.04in 0.04in;\">\n" +
                "                <p>\n" +
                "                    4\n" +
                "                </p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<p>\n" +
                "    <img width=\"530\" height=\"340\" src=\"http://api.map.baidu.com/staticimage?center=116.404,39.915&zoom=10&width=530&height=340&markers=116.404,39.915\"/>\n" +
                "</p>\n" +
                "<p>\n" +
                "    <br/>\n" +
                "</p>\n" +
                "<p>\n" +
                "    <iframe class=\"ueditor_baidumap\" src=\"http://t.weixinuc.com/static/backend/js/ueditor/dialogs/map/show.html#center=116.404,39.915&zoom=10&width=530&height=340&markers=116.404,39.915&markerStyles=l,A\" frameborder=\"0\" width=\"534\" height=\"344\"></iframe>\n" +
                "</p>");

        doc.select("img").attr("width", "98%").attr("height", "98%");
        doc.select(".ueditor_baidumap").attr("width", "98%");
        doc.select("[style]").not("[contenteditable]").removeAttr("style");
        System.out.println(doc.select("body>*"));

        System.out.println("---------------------------------");

        System.out.println(doc.text());
    }
    
    /***
     * 修复富文本 HTML 代码的思路
     * 1. 使用　Jsoup　解析　HTML 代码片段，将会出现一个修正过的版本；
     * 2. 处理掉一些易干扰的标签，如　font、br、hr...
     * 3. 针对性的移除一些不必要的属性。
     */

}
