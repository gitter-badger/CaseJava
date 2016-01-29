package jdk;

import org.junit.Test;

import java.util.*;

/**
 * Created by luohao4 on 2016/1/29.
 */
public class Disredom {



    @Test
    public void main() {
        System.out.println(System.currentTimeMillis());
        final Set<Integer> set = new HashSet<Integer>();
        final Set<Integer> tss = new HashSet<Integer>();
        for (int j = 0; j < 100; j++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        Integer ts = new Random(System.currentTimeMillis()).nextInt();
                        Integer id = Math.abs(UUID.randomUUID().hashCode());
                        /*if (set.contains(id)) {
                            System.out.print(Thread.currentThread().getName() + " - ");
                            System.out.printf("id - %s - 重复\n", id);
                        } else {
                            set.add(id);
                        }*/
                        if(tss.contains(ts)){
                            System.out.print(Thread.currentThread().getName() + " - ");
                            System.out.printf("ts - %s - 重复\n", id);
                        } else {
                            tss.add(ts);
                        }
                    }
                }
            }, 1);
        }
        System.out.println(System.currentTimeMillis());
    }

}
