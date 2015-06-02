package api.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by MurphyL on 5/27/2015.
 */
public class TestServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8800);
        for (int i = 0; ; i++) {
            new Thread(new ConnectionThread(i, socket.accept())).start();
        }
    }

}
