package us.cijian.icarus.utils;

/**
 * Created by luohao4 handle 2016/2/29.
 * ref https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
 * ref https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
 */
public enum StatusCode {

    CONTINUE(100),
    SWITCHING_PROTOCOLS(101),
    PROCESSING(102),
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NON_AUTHORITATIVE_INFORMATION(203),
    NO_CONTENT(204),
    RESET_CONTENT(205),
    PARTIAL_CONTENT(206),
    MULTI_STATUS(207),
    ALREADY_REPORTED(208),
    IM_USED(226),
    MULTIPLE_CHOICES(300),
    FORBIDDEN(403),
    NOT_FOUND(404);
    /***
     * 301 Moved Permanently
     * 302 Found
     * 303 See Other
     * 304 Not Modified
     * 305 Use Proxy
     * 306 Switch Proxy
     * 307 Temporary Redirect
     * 308 Permanent Redirect
     * 400 Bad Request
     * 401 Unauthorized
     * 402 Payment Required
     * 403 Forbidden
     *
     * 405 Method Not Allowed
     * 406 Not Acceptable
     * 407 Proxy Authentication Required
     * 408 Request Timeout
     * 409 Conflict
     * 410 Gone
     * 411 Length Required
     * 412 Precondition Failed
     * 413 Payload Too Large
     * 414 URI Too Long
     * 415 Unsupported Media Type
     * 416 Range Not Satisfiable
     * 417 Expectation Failed
     * 418 I'm a teapot
     * 421 Misdirected Request
     * 422 Unprocessable Entity
     * 423 Locked
     * 424 Failed Dependency
     * 426 Upgrade Required
     * 428 Precondition Required
     * 429 Too Many Requests
     * 431 Request Header Fields Too Large
     * 451 Unavailable For Legal Reasons
     * 500 Internal HttpServer Error
     * 501 Not Implemented
     * 502 Bad Gateway
     * 503 Service Unavailable
     * 504 Gateway Timeout
     * 505 HTTP Version Not Supported
     */

    private int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    @Override
    public String toString() {
        return String.format(" %s %s" , code, name());
    }
}