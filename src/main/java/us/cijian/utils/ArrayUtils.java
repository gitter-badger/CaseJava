package us.cijian.utils;

/**
 * Created by luohao4 on 2015/2/2.
 */
public final class ArrayUtils {

    public static final boolean isEmpty(Object[] objects) {
        return null == objects || objects.length == 0;
    }

    public static final String join(String[] objects, String joiner){
        if(null == objects){
            throw new NullPointerException();
        }
        if (objects.length == 0) {
            return "";
        }
        StringJoiner sj = new StringJoiner(joiner);
        for (String object : objects) {
            sj.add(object);
        }
        return sj.toString();
    }

    public static void main(String[] a){
        StringJoiner sj = new StringJoiner("s");
        sj.add("a");
        sj.add("b");
        System.out.println(sj.toString());
    }

}
