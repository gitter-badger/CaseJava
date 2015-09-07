package api.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by luohao4 on 2015/9/7.
 */
public class CopyListTest {

    @Test
    public void test() {
        List<String> sList = new ArrayList<String>();
        sList.add("a");
        sList.add("b");

        System.out.println(sList.hashCode());
        System.out.println(sList);

        List<String> tList = new ArrayList<String>();

        Collections.copy(tList, tList);

        System.out.println(tList.hashCode());
        System.out.println(tList);
    }
    
}
