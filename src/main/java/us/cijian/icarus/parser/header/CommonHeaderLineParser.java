package us.cijian.icarus.parser.header;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by luohao4 on 2016/2/25.
 */
public class CommonHeaderLineParser implements IHeaderLineParser {

    public Map<String, String> parse(String line, Pattern pattern) {
        final String val = pattern.matcher(line).replaceAll("");
        final String key = line.replace(":" + val, "");
        return new HashMap<String, String>(){{
            this.put(key.trim(), val.trim());
        }};
    }
}