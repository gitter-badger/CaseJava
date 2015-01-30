package us.cijian.dynamic.proxy;


public interface Query {
	
	public void setSql(String sql);
	
	public Object doSelect();

}
