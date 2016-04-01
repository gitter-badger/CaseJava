package us.cijian.icarus;

import us.cijian.icarus.handler.RequestHandler;

import java.io.*;
import java.net.ServerSocket;

/**
 * Created by luohao4 on 2016/2/25.
 */
public final class Icarus {

    public static void serve(int port, String webRoot) throws IOException {
        ServerSocket socket = new ServerSocket(port);
        int index = 0;
        do {
            String name = "Icarus-" + index ++;
            new Thread(new RequestHandler(socket.accept(), webRoot), name).start();
        } while (true);
    }

}