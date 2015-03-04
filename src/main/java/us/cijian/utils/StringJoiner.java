package us.cijian.utils;

import java.util.ArrayList;
import java.util.List;

public class StringJoiner {

	private String joiner;

	private List<String> items;

	public StringJoiner() {
		items = new ArrayList<String>();
	}

	public StringJoiner(String joiner) {
		this();
		this.joiner = joiner;
	}

	public void setJoiner(String joiner) {
		this.joiner = joiner;
	}

	public void add(String item) {
		items.add(item);
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		if(null == joiner){
			joiner = result.toString();
		}
		if (null != items && items.size() != 0) {
			for (int i = 0; i < items.size(); i++) {
				if (i > 0) {
					result.append(joiner);
				}
				result.append(items.get(i));
			}
		}
		return result.toString();
	}
}
