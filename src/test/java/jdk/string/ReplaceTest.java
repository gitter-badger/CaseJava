package jdk.string;

import org.junit.Test;

/**
 * Created by MurphyL on 2016/4/8.
 */
public class ReplaceTest {

    public void testForLoopAppend() {
        String t = "";
        for (int i = 0; i< 13; i ++) {
            t += "*";
        }
    }

    public void testReplace() {
        String t = "abcdefghijklmn";
        t.replaceFirst("^\\w{13}", "***********");
    }

    public void testJoin(){
        String i = "********" + "abcdefghijklmn".substring(0, 2);
    }

    @Test
    public void test1() {
        testReplace();
    }

    @Test
    public void test() {
        int count = 1000;
        long ct = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - ct);
        for (int i = 0; i< count; i ++) {
            testForLoopAppend();
        }
        System.out.println(System.currentTimeMillis() - ct);
        ct = System.currentTimeMillis();
        for (int i = 0; i< count; i ++) {
            testReplace();
        }
        System.out.println(System.currentTimeMillis() - ct);
        ct = System.currentTimeMillis();
        for (int i = 0; i< count; i ++) {
            testJoin();
        }
        System.out.println(System.currentTimeMillis() - ct);
    }
    
}
