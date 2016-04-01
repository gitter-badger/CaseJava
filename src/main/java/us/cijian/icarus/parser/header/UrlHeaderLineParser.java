package us.cijian.icarus.parser.header;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by luohao4 on 2016/2/25.
 */
public class UrlHeaderLineParser implements IHeaderLineParser {

    private static final Pattern  PREFIX = Pattern.compile("^(GET|POST)(\\s)*");
    private static final Pattern  SUFFIX = Pattern.compile("\\s*HTTP(\\S|\\s)+$");

    public Map<String,String> parse(final String line, Pattern pattern){
        return new HashMap<String, String>(){{
            String temp = PREFIX.matcher(line).replaceAll("");
            temp = SUFFIX.matcher(temp).replaceAll("");
            String[] flags = line.split(temp);
            this.put("method", flags[0].trim());
            this.put("uri", temp);
            if(flags.length > 1){
                this.put("protocol", flags[1].trim());
            }
        }};
    }

}