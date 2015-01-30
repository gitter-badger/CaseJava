package us.cijian.dynamic.proxy;

public class Count implements Query {
	
	private final static String COUNT_SQL_TEMPLATE = "select count(1) from (%s)";
	
	private String sql;
	
	public void setSql(String sql) {
		this.sql = sql;
	}



	public Object doSelect() {
		System.out.println(String.format(COUNT_SQL_TEMPLATE, sql));
		return null;
	}

}
