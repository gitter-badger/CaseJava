package biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RemoveItemFromArrayTest {

	private List<String> list;
	private String[] items = { "a", "b", "c", "d" };

	@Before
	public void before() {
		list = new ArrayList<String>(Arrays.asList(items));
	}

	/**
	 * 当一个元素被删除时，列表收缩的大小以及指针改变了。所以想要在循环内利用指针删除多个元素是无法正常进行的。
	 */
	@Test
	public void testForIn() {
		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
		Assert.assertTrue(list.contains("b"));
		Assert.assertTrue(list.contains("d"));
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testForEach() {
		for (String item : list) {
			if ("a".equals(item)) {
				list.remove(item);// 异常
			}
		}
	}

	/**
	 * 对比前一个测试说明， for/each 并非调用的 Iterator 保证这个方法不出错的前提是，让 remove 在 next 方法之前执行
	 */
	@Test
	public void testInIterator() {
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			if ("a".equals(iter.next())) {
				iter.remove();
			}
		}
		Assert.assertTrue(!list.contains("a"));
	}

	@Test(expected = IllegalStateException.class)
	public void testInIteratorError() {
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			iter.remove();// 第一次到此处时异常，出错原因可以查看 ArrayList#iterator 方法的源码
		}
		Assert.assertTrue(!list.contains("a"));
	}

}
