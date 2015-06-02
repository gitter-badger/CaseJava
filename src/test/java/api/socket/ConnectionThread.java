package api.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by luohao4 on 2015/6/2.
 */
public class ConnectionThread implements Runnable {

    private Integer count;
    private Socket socket;

    public ConnectionThread(Integer count, Socket socket) {
        this.count = count;
        this.socket = socket;
    }

    public void run() {
        try {
            String header = getHeader(socket.getInputStream());
            System.out.println(header);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println("Content_Type:text/html");
            writer.println("Content_Length:" + 2);
            writer.println("");
            writer.println("as");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getHeader(InputStream stream){
        Scanner reader = new Scanner(stream).useDelimiter("\\A");
        return reader.hasNext() ? reader.next(): "";
    }
}
