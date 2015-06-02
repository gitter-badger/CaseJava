package api.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            Scanner scanner = new Scanner(socket.getInputStream());
            System.out.println(scanner.useDelimiter("\\A").next());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
