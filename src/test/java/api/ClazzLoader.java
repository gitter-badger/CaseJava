package api;

import api.string.StringTest;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by luohao4 on 2015/12/7.
 */
public class ClazzLoader {


    public static void main(String[] args) {
        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());

                /*try {
                    Class.forName(StringTest.class.getName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }*/
            }
        }, 1000l, 200l);
    }


}
