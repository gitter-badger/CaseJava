package us.cijian.zira;

import com.alibaba.fastjson.JSON;
import us.cijian.common.Handler;
import us.cijian.net.ConnectionUtils;
import us.cijian.net.HttpServer;
import us.cijian.net.SocketUtils;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MurphyL handle 2016/4/14.
 */
public class ZiraServer implements Handler<Socket>, Runnable {

    protected final static int port = 9090;

    Pattern ziraConfigPattern = Pattern.compile("^ZiraConf-\\w+:\\s");

    public void handle(Socket socket) throws Exception {
        BufferedReader bf = SocketUtils.getBufferedReaderFromInputStream(socket);
        StringBuffer sb = new StringBuffer("HTTP/1.1 200 OK\nContent-Type: text/plain; charset=utf-8\n\n");
        final Conf conf = new Conf();
        for (String line = bf.readLine(); null != line && line.trim().length() > 0; line = bf.readLine()) {
            Matcher configMatcher = ziraConfigPattern.matcher(line);
            if(configMatcher.find()){
                sb.append(line).append("\n");
                conf.val(line, configMatcher.replaceFirst(""));
            }
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    //System.out.println("http://127.0.0.1:" + (conf.getPort() + 100));
                    ConnectionUtils.getBufferedReader("http://127.0.0.1:" + (conf.getPort() + 100), new HashMap<String, String>(){{
                        put("ZiraCallback", conf.getGuid());
                    }});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, conf.getSpec());
        SocketUtils.writeOutputStream(socket, sb);
        socket.close();
    }

    public void run() {
        try {
            HttpServer.newInstance(port, new ZiraServer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Conf {
        private int port;
        private int spec;
        private String guid;

        private void val(String line, String val){
            if(line.startsWith("ZiraConf-Port: ")){
                port = Integer.valueOf(val);
            }
            if(line.startsWith("ZiraConf-Guid: ")){
                guid = val;
            }
            if(line.startsWith("ZiraConf-Spec: ")){
                spec = Integer.valueOf(val);
            }
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public int getSpec() {
            return spec;
        }

        public void setSpec(int spec) {
            this.spec = spec;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new ZiraServer(), "ZiraServer").start();
        for (int i = 0; i < 9; i++) {
            try {
                new ZiraClient().regist(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
