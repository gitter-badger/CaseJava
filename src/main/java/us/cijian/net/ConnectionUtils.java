package us.cijian.net;

import us.cijian.zira.ZiraServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.UUID;

/**
 * Created by luohao4 on 2016/4/15.
 */
public final class ConnectionUtils {

    private ConnectionUtils() {
    }

    public static BufferedReader getBufferedReader(String path, Map<String, String> params) throws Exception{
        URL url = new URL(path);
        URLConnection connection = url.openConnection();
        for (Map.Entry<String, String> param : params.entrySet()) {
            connection.setRequestProperty(param.getKey(), param.getValue());
        }
        connection.connect();
        InputStream is = connection.getInputStream();
        return new BufferedReader(new InputStreamReader(is));
    }

}
