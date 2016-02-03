package biz;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Created by luohao4 on 2016/1/27.
 */
public class NonUTF8Charactor {

    @Test
    public void testFilterNonUTF8Character() {
        // Pattern reg = Pattern.compile("[\\x00-\\x08\\x1b\\x0b-\\x0c\\x0e-\\x1f\\x7f]");
        Pattern reg = Pattern.compile("[\\S]");
        String code = "\b";
        if(reg.matcher(code).find()){
            Assert.assertTrue(Integer.toHexString(code.charAt(0)).equals("8"));
        }
    }
    
}
