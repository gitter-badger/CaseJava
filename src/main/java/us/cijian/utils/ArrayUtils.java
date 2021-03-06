package us.cijian.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by MurphyL handle 2015/2/2.
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
    
	@SuppressWarnings("unchecked")
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

}
