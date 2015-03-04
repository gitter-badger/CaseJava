package us.cijian.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    
    public static final List<String> toList(String[] array) {
    	return let(array, null);
    }
    
	public static final <T extends Collection<String>> T let(String[] array, Class<T> tClazz){
    	T result = null;
    	if(null == tClazz){
    		result = (T) new ArrayList<String>();
    	} else {
    		try {
    			result = tClazz.newInstance();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	if(null != array && array.length > 0){
    		for (String e : array) {
				result.add(e);
			}
    	}
		return result;
    }

    public static void main(String[] a){
        StringJoiner sj = new StringJoiner("-", new String[]{"a", "b", "c", "d"});
        sj.add("a");
        sj.add("b");
        System.out.println(sj.toString());
    }

}
