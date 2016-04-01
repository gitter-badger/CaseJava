package us.cijian.icarus.handler;

import us.cijian.icarus.model.HttpRequest;
import us.cijian.icarus.parser.RequestHeadersParser;
import us.cijian.icarus.utils.FileUtils;

import java.io.*;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by luohao4 on 2016/2/25.
 */
public class RequestHandler implements Runnable {

    private Socket socket;
    private String webRoot;

    public RequestHandler(Socket socket, String webRoot) {
        this.socket = socket;
        this.webRoot = webRoot;
    }

    @Override
    public void run() {
        HttpRequest request = null;
        PrintWriter writer = null;
        StringJoiner response = new StringJoiner("\n");
        try {
            request = parseRequest();
            writer = new PrintWriter(socket.getOutputStream());
            String code = " 200 OK";
            response.add(request.getProtocol() + code);
            response.add("Server: Icarus/1.0");
            response.add("Content-Type: text/html;charset=UTF-8");
            response.add("Content-Language: chunked");
            response.add("Date: " + new Date().toString() + "\n");
            System.out.println(response.toString());
            writer.write(response.toString());
            writer.write(new String(FileUtils.readFileAsString(Paths.get(webRoot + request.getURI()))));
        }catch (IOException e) {
            if(null != request){
                System.out.println(request);
                try {
                    if (null ==writer){
                        writer = new PrintWriter(socket.getOutputStream());
                    }
                    writer.write(request.getProtocol() + e.getMessage());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            } else {
                System.out.println(socket);
            }
        } finally {
            writer.flush();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized HttpRequest parseRequest() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        Map<String, String> lineItems, headers = new HashMap();
        do {
            lineItems = RequestHeadersParser.parse(line);
            if (null != lineItems) {
                headers.putAll(lineItems);
            } else {
                System.out.println(line);
            }
            line = reader.readLine();
        } while (null != line && !line.trim().isEmpty());
        return new HttpRequest(headers);
    }
}