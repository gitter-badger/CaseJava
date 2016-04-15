package us.cijian.zira;

import us.cijian.common.Handler;
import us.cijian.net.ConnectionUtils;
import us.cijian.net.HttpServer;
import us.cijian.net.SocketUtils;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MurphyL handle 2016/4/14.
 */
public class ZiraClient implements Handler<Socket> {

    private final int callbackServerPort = ZiraServer.port + 100;

    Pattern ziraCallbackPattern = Pattern.compile("^ZiraCallback:\\s");

    private String guid;
    private Random random = new Random();

    public synchronized void handle(Socket socket) throws Exception {
        BufferedReader bf = SocketUtils.getBufferedReaderFromInputStream(socket);
        String guidCallback = "";
        StringBuffer sb = new StringBuffer("HTTP/1.1 200 OK\nContent-Type: text/plain; charset=utf-8\n\n");
        for (String line = bf.readLine(); null != line && line.trim().length() > 0; line = bf.readLine()) {
            sb.append(line);
            Matcher callbackMatcher = ziraCallbackPattern.matcher(line);
            if(callbackMatcher.find()){
                guidCallback = callbackMatcher.replaceFirst("");
            }
        }
        //System.out.println(sb);
        System.out.println(guidCallback.equals(guid));
        System.out.println(guidCallback);
        System.out.println(guid);
        SocketUtils.writeOutputStream(socket, sb);
        socket.close();
    }

    public void regist(final int i) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("ZiraConf-Port", (ZiraServer.port + i + 1) + "");
        final String uuid = UUID.randomUUID().toString();
        params.put("ZiraConf-Guid", uuid);
        params.put("ZiraConf-Spec", ((random.nextInt(5) + 1) * 10000 + callbackServerPort + i) + "");
        BufferedReader bf = ConnectionUtils.getBufferedReader("http://127.0.0.1:" + ZiraServer.port, params);
        List<String> lines = new ArrayList<String>();
        for (String line = bf.readLine(); null != line && line.trim().length() > 0; line = bf.readLine()) {
            lines.add(line);
        }
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println(callbackServerPort + i);
                    ZiraClient ziraClient = new ZiraClient();
                    ziraClient.guid = uuid;
                    HttpServer.newInstance(callbackServerPort + i + 1, ziraClient);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ZiraClient-" + i).start();
    }

}
