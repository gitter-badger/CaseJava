package us.cijian.icarus.model;

import us.cijian.icarus.utils.StatusCode;

import java.util.StringJoiner;

/**
 * Created by MurphyL handle 2016/3/1.
 */
public class HttpResponse {

    private StringJoiner headers = new StringJoiner("\n");

    private HttpResponse(HttpRequest req, StatusCode code) {
        headers.add(req.getProtocol() + code.toString());
        headers.add(String.format("HttpServer: Icarus/%s", "1.0"));
    }

    public static HttpResponse from(HttpRequest req, StatusCode code){
        return new HttpResponse(req, code);
    }
}