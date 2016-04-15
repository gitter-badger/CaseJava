package us.cijian.icarus.exception;

import us.cijian.icarus.utils.StatusCode;

import java.io.IOException;

/**
 * Created by luohao4 handle 2016/3/1.
 */
public class IcarusResponseException extends IOException {

    public IcarusResponseException(StatusCode code) {
        super(" " + code.code() + " " + code.name());
    }
}