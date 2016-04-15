package us.cijian.icarus.handler;

import com.alibaba.fastjson.JSON;
import us.cijian.icarus.parser.RequestHeadersParser;
import us.cijian.icarus.utils.Headers;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by MurphyL handle 2016/2/25.
 */
public class RequestHandler implements Runnable {

    private Socket socket;
    private String webRoot;

    public RequestHandler(Socket socket, String webRoot) {
        this.socket = socket;
        this.webRoot = webRoot;
    }

    public void run() {
        if(null == socket || null == webRoot){
            return;
        }
        parseRequest();
        writeResponse();
    }


    private boolean writeResponse(){
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.write("ad");
            writer.flush();
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean parseRequest(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Pattern patterns = Pattern.compile(Headers.getHeaderPattern());
            HashMap<String, String> headers = new HashMap<String, String>();
            for (String line = reader.readLine(); null != line && line.trim().length() > 0; line = reader.readLine()){
                if(!patterns.matcher(line).find()){
                    System.out.println(line);
                } else {
                    headers.putAll(RequestHeadersParser.parse(line));
                }
            }
            System.out.println(JSON.toJSONString(headers, true));
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}