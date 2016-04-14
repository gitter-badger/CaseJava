package us.cijian.zira;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luohao4 on 2016/4/14.
 */
public class ZiraServer {

    protected final static int port = 9090;

    private Map<String, String> queen = new HashMap<String, String>();
    Pattern ziraConfigPattern = Pattern.compile("^ZiraConf-\\w+:");

    public void serve() throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        do {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer("HTTP/1.1 200 OK\nContent-Type: text/plain; charset=utf-8\n\n");
            for (String line = bf.readLine(); null != line && line.trim().length() > 0; line = bf.readLine()) {
                Matcher configMatcher = ziraConfigPattern.matcher(line);
                if(configMatcher.find()){
                    sb.append(line).append("\n");
                }
            }
            OutputStream os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
            writer.write(sb.toString());
            writer.flush();
            os.flush();
            socket.close();
        } while (true);

    }

    public static void main(String[] args) throws Exception {
        new ZiraServer().serve();
    }

}
