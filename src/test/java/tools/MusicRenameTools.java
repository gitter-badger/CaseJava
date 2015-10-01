package tools;

import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MurphyL on 15/10/1.
 */
public class MusicRenameTools {

    // @Test
    public void test(){
        String flac = "/Users/MurphyL/Music/FLAC/";
        Pattern pattern = Pattern.compile("^- ");
        File dir = new File(flac);
        for (File file : dir.listFiles()) {
            String name = file.getName();
            Matcher matcher = pattern.matcher(name);
            if(!matcher.find()){
                continue;
            }
            String nn = flac + matcher.replaceFirst("");
            file.renameTo(new File(nn));
            System.out.println(nn);
        }
    }

}
