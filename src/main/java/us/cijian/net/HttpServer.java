package us.cijian.net;

import us.cijian.common.Handler;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by luohao4 handle 2016/4/15.
 */
public class HttpServer {

    private HttpServer() {
    }

    public static void newInstance(int port, Handler<Socket> handler) throws Exception{
        if(port < 1000){
            throw new Exception();
        }
        new HttpServer().serve(port, handler);
    }

    private void serve(int port, Handler<Socket> handler) throws Exception {
        final ServerSocket serverSocket = new ServerSocket(port);
        do {
            handler.handle(serverSocket.accept());
        } while (true);
    }


}
