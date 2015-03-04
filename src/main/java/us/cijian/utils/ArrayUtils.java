package us.cijian.utils;

/**
 * Created by luohao4 on 2015/2/2.
 */
public final class ArrayUtils {

    public static final boolean isEmpty(Object[] objects) {
        return null == objects || objects.length == 0;
    }

    public static final String join(String[] objects, String joiner){
        return new StringJoiner(joiner, objects).toString();
    }

    public static void main(String[] a){
        StringJoiner sj = new StringJoiner("-", new String[]{"a", "b", "c", "d"});
        sj.add("a");
        sj.add("b");
        System.out.println(sj.toString());
    }

}
