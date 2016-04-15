package us.cijian.common;

/**
 * Created by luohao4 handle 2016/4/15.
 */
public interface Handler<T> {

    void handle(T t) throws Exception;

}
