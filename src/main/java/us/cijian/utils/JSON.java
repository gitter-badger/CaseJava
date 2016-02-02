package us.cijian.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luohao4 on 2016/2/2.
 */
public final class JSON {

    private final static Pattern KV_ITEM_PATTERN = Pattern.compile("^(\\s*)\\\"(\\s|\\S*)\\\"(\\s*):\\S*$");
    private final static Pattern KEY_ITEM_PATTERN = Pattern.compile("^(\\s*)\\\"(\\s|\\S*)\\\"(\\s*):\\B");
    private final static Pattern HASH_WRAPPER_PATTERN = Pattern.compile("^(\\s*)\\{(\\s|\\S*)\\}$");
    private final static Pattern ARRAY_WRAPPER_PATTERN = Pattern.compile("^(\\s*)\\[(\\s|\\S*)\\](\\s*)$");

    public static void main(String[] args) {
        System.out.println(valid("   {   \"a\":1}"));
        ;
    }

    public static boolean valid(String jsonString) {
        if (null == jsonString || jsonString.trim().length() == 0) {
            return false;
        }
        String temp = jsonString.trim();
        if (temp.length() == 2) {
            return HASH_WRAPPER_PATTERN.matcher(temp).find() ||
                    ARRAY_WRAPPER_PATTERN.matcher(temp).find();
        }
        String[] items = temp.substring(1, temp.length() - 1).split(",");
        for (String item : items) {
            if (!KV_ITEM_PATTERN.matcher(item).find()) {
                return false;
            }
            String val = KEY_ITEM_PATTERN.matcher(item.trim()).replaceFirst("");
            System.out.println(val);
            if (HASH_WRAPPER_PATTERN.matcher(val).find() || ARRAY_WRAPPER_PATTERN.matcher(val).find()) {
                if (!valid(val)) {
                    return false;
                }
            }
        }
        return true;
    }


}
