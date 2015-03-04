package us.cijian.utils;

import java.util.ArrayList;
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

	public StringJoiner(String joiner, final String[] items) {
		this(joiner, ArrayUtils.toList(items));
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
