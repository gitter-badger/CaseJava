package us.cijian.zira;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by luohao4 on 2016/4/14.
 */
public class ZiraClient {

    private Map<Integer, String> validateUUIDs = new HashMap<Integer, String>();
    private Random random = new Random();

    public void regist(int i) throws Exception {
        URL url = new URL("http://127.0.0.1:" + ZiraServer.port);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("ZiraConf-Port", (ZiraServer.port + i + 1) + "");
        String uuid = UUID.randomUUID().toString();
        connection.setRequestProperty("ZiraConf-Uuid", uuid);
        connection.setRequestProperty("ZiraConf-Spec", random.nextInt(100) * 1000 + "");
        validateUUIDs.put(i, uuid);
        connection.connect();
        InputStream is = connection.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        List<String> lines = new ArrayList<String>();
        for (String line = bf.readLine(); null != line && line.trim().length() > 0; line = bf.readLine()) {
            lines.add(line);
        }
        System.out.println(JSON.toJSONString(lines, true));
    }

    public void callback(int i){

    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 9; i++) {
            new ZiraClient().regist(i);
        }
    }

}
