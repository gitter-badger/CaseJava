package us.cijian.icarus.model;

import java.util.Map;

/**
 * Created by luohao4 on 2016/3/1.
 */
public class HttpRequest {

    private Map<String, String> headers;

    public HttpRequest(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getProtocol(){
        return headers.get("protocol");
    }

    public String getURI(){
        return headers.get("uri");
    }
}