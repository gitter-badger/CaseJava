
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by luohao4 on 2015/11/23.
 */
public class DailyBuildTimeTask {

    public static void main(String[] args) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Runtime runtime = Runtime.getRuntime();
                try {
                    Process process = runtime.exec("ipconfig");
                    System.out.println(dateFormat.format(new Date()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 5000, 5000);
    }

}
