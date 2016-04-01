package us.cijian.icarus.parser;

import us.cijian.icarus.parser.header.CommonHeaderLineParser;
import us.cijian.icarus.parser.header.IHeaderLineParser;
import us.cijian.icarus.parser.header.UrlHeaderLineParser;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by luohao4 on 2016/2/25.
 */
public enum RequestHeadersParser {
    /** ref https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol#Request_methods **/
    URI_HTTP("^(GET|POST)(\\S|\\s)+HTTP(\\S|\\s)+$", new UrlHeaderLineParser()),
    /** ref https://en.wikipedia.org/wiki/List_of_HTTP_header_fields **/
    COMMON_LINE("^(Host|Accept\\S*|Connection|Cache-Control|User-Agent|Upgrade-Insecure-Requests|Pragma|Referer|DNT|X-Requested-With|Origin|Content-\\S*):", new CommonHeaderLineParser());

    private Pattern pattern;
    private IHeaderLineParser parser;

    RequestHeadersParser(String pattern, IHeaderLineParser parser) {
        this.parser = parser;
        this.pattern = Pattern.compile(pattern);
    }

    public static Map<String,String> parse(String line){
        if(null != line) {
            for (RequestHeadersParser header : RequestHeadersParser.values()) {
                if(header.pattern.matcher(line).find()){
                    return header.parser.parse(line, header.pattern);
                }
            }
        }
        return null;
    }

}