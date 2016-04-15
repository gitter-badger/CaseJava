package us.cijian.net;

import java.io.*;
import java.net.Socket;

/**
 * Created by MurphyL on 2016/4/15.
 */
public final class SocketUtils {

    private SocketUtils() {
    }

    public static BufferedReader getBufferedReaderFromInputStream(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private static PrintWriter getPrintWriterFromOutputStream(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream());
    }

    public static void writeOutputStream(Socket socket, StringBuffer sb) throws IOException {
        PrintWriter writer = getPrintWriterFromOutputStream(socket);
        writer.write(sb.toString());
        writer.flush();
    }
}
