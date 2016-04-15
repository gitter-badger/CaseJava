package us.cijian.icarus.utils;

import us.cijian.icarus.exception.IcarusResponseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by luohao4 handle 2016/2/25.
 */
public final class FileUtils {

    public static final String readFileAsString(Path path) throws IOException {
        if(Files.notExists(path)){
            throw new IcarusResponseException(StatusCode.NOT_FOUND);
        }
        if(!Files.isReadable(path)){
            throw new IcarusResponseException(StatusCode.FORBIDDEN);
        }
        if(Files.isDirectory(path)){
            return readFileAsString(Paths.get(path + "/index.html"));
        }
        return new String(Files.readAllBytes(path));
    }

}