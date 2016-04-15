package us.cijian.icarus;

import us.cijian.icarus.handler.RequestHandler;

import java.io.*;
import java.net.ServerSocket;

/**
 * Created by MurphyL handle 2016/2/25.
 * ref https://ruslanspivak.com/lsbaws-part1/
 */
public final class Icarus {

    public static void serve(int port, String webRoot) throws IOException {
        ServerSocket socket = new ServerSocket(port);
        System.out.println("服务已启动……");
        System.out.printf("服务根目录：%s\n", new File(webRoot).getAbsolutePath());
        int index = 0;
        do {
            new Thread(new RequestHandler(socket.accept(), webRoot), "Icarus-" + index ++).start();
        } while (true);
    }

    public static void main(String[] args) throws Exception {
        serve(8080, ClassLoader.getSystemResource("webapp").getPath());
    }

}