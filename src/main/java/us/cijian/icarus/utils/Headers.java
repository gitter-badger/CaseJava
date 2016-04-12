package us.cijian.icarus.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luohao4 on 2016/4/12.
 */
public final class Headers {

    private Headers() {
    }

    private static final List<String> lines = Arrays.asList(new String[]{
            /*"Accept(-(Charset|Encoding|Language|Datetime|Patch|Ranges))?",
            "Access-Control-Allow-Origin",
            "Age",
            "Allow",
            "Authorization",
            "Cache-Control",
            "Connection",
            "Cookie",
            "Content-(Disposition|Encoding|Language|Length|Location|MD5|Range|Type)",
            "Date",
            "DNT",
            "ETag",
            "Expect",
            "Expires",
            "Forwarded",
            "Front-End-Https",
            "From",
            "Host",
            "If-(Match|Modified-Since|None-Match|Range|Unmodified-Since)",
            "Last-Modified",
            "Link",
            "Location",
            "Max-Forwards",
            "Origin",
            "P3P",
            "Pragma",
            "Proxy-(Authorization|Connection)",
            "Public-Key-Pins",
            "Range",
            "Referer",
            "Refresh",
            "Retry-After",
            "Server",
            "Set-Cookie",
            "Status",
            "Strict-Transport-Security",
            "TE",
            "Trailer",
            "Transfer-Encoding",
            "TSV",
            "Upgrade",
            "User-Agent",
            "Upgrade",
            "X-(ATT-DeviceId|Content-Duration|Csrf-Token|Forwarded-(For|Host|Proto)|Frame-Options|Http-Method-Override|Requested-With|UA-Compatible|UIDH|Wap-Profile|XSS-Protection)",
            "Vary",
            "Via",
            "Warning",
            "WWW-Authenticate"*/"[A-Za-z0-9]+(-[A-Za-z0-9]+)*"
    });

    public static String getHeaderPattern() {
        StringBuffer patterns = new StringBuffer();
        for (String line : lines) {
            if(patterns.length() > 0){
                patterns.append("|");
            }
            patterns.append("(").append(line).append(":)");
        }
        return patterns.toString();
    }
}
