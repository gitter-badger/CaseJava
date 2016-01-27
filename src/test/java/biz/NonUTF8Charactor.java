package biz;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Created by luohao4 on 2016/1/27.
 */
public class NonUTF8Charactor {

    @Test
    public void testFilterNonUTF8Charactor() {
        String str = "若素 创意日式家用木餐具中式吃米饭碗喝汤碗圆套碗小菜碗套装\b大漆色大号\b龟甲碗";
        System.out.println("若素 创意日式家用木餐具中式吃米饭碗喝汤碗圆套碗小菜碗套装\b大漆色大号\b龟甲碗");
        Pattern reg = Pattern.compile("[\\x00-\\x08\\x1b\\x0b-\\x0c\\x0e-\\x1f\\x7f]");
        System.out.println(reg.matcher(str).replaceAll(""));
        String code = "号\b龟";
        for (int i = 0; i < code.length(); i++) {
            System.out.println(Integer.toHexString(code.charAt(i)));
        }
    }
    
}
