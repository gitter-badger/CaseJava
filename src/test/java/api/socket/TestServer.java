package api.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by MurphyL on 5/27/2015.
 */
public class TestServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        Socket socket = serverSocket.accept();
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        while (null != line && line.length() > 0) {
            System.out.println(reader.readLine());
        }
        writer.write(1);
        writer.flush();
        writer.close();
    }

}
