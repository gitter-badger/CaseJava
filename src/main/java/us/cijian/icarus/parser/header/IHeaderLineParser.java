package us.cijian.icarus.parser.header;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by luohao4 on 2016/2/25.
 */
public interface IHeaderLineParser {

    Map<String, String> parse(String line, Pattern pattern);

}