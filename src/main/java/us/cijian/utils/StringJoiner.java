package us.cijian.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringJoiner {

	private static final String EMPTY = "";

	private String joiner;

	private List<String> items;

	public StringJoiner() {
		this(EMPTY);
	}

	public StringJoiner(String joiner) {
		this(joiner, new ArrayList<String>());
	}

	/***
	 * Java开发者易犯错误Top10 - Top1. 数组转换为数组列表
	* 将数组转换为数组列表，开发者经常会这样做：
	* List<String> list = Arrays.asList(arr);  
	* Arrays.asList()将返回一个数组内部是私有静态类的ArrayList，这不是java.util.ArrayList类。
	* java.util.Arrays.ArrayList 类有set()、 get()、 contains()方法，但是没有任何加元素的方法，因此它的大小是固定的。你应该这么做来创建一个真正的 ArrayList：
	* ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));  
	* ArrayList的构造函数能够接受一个集合类型，这也是java.util.Arrays.ArrayList的超级类型。
	 * @param joiner
	 * @param items
	 */
	public StringJoiner(String joiner, String[] items) {
		this(joiner, new ArrayList<String>(Arrays.asList(items)));
	}

	public StringJoiner(String joiner, List<String> items) {
		if (null == joiner) {
			joiner = EMPTY;
		}
		if (items == null) {
			items = new ArrayList<String>();
		}
		this.joiner = joiner;
		this.items = items;
	}

	public void setJoiner(String joiner) {
		this.joiner = joiner;
	}

	public void add(String item) {
		items.add(item);
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		if (null == joiner) {
			joiner = result.toString();
		}
		if (null != items && items.size() != 0) {
			for (String item : items) {
				if (result.length() > 0) {
					result.append(joiner);
				}
				result.append(item);
			}
		}
		return result.toString();
	}
}
