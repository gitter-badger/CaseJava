package us.cijian.joda;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Weeks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JodaTest {

	private DateTime dt;

	private static final String DF = "yyyy-MM-dd HH:mm:ss SSS";

	@Before
	public void beforeTest() {
		dt = new DateTime();
	}

	/**
	 * 测试　Joda 的静态方法
	 */
	@Test
	public void testStaticMethod() {
		System.out.println("系统时间：" + DateTime.now().toString(DF));
	}

	/**
	 * 测试 Joda 的成员方法
	 */
	@Test
	public void testGetter() {
		System.out.println("年份：" + dt.getYearOfCentury());
		System.out.println("年：" + dt.getYear());
		System.out.println("月：" + dt.getMonthOfYear());
		System.out.println("日：" + dt.getDayOfMonth());
		System.out.println("时：" + dt.getHourOfDay());
		System.out.println("分：" + dt.getMinuteOfHour());
		System.out.println("秒：" + dt.getSecondOfMinute());

	}

	/**
	 * 时间计算
	 */
	@Test
	public void testCalc() {
		dt = dt.plusYears(-2);
		System.out.println("===> 2年前");
		System.out.println("具体时间：" + dt.toString(DF));

		dt = dt.plusDays(4);
		System.out.println("===> ４天后");
		System.out.println("具体时间：" + dt.toString(DF));

		dt = dt.plusYears(3);
		System.out.println("===> 3年后");
		System.out.println("具体时间：" + dt.toString(DF));
		System.out.println(dt.toString(DF) + (dt.isAfterNow() ? "晚" : "早") + "于当前");

		dt = dt.minusDays(400);
		System.out.println("===> 400天前");
		System.out.println("具体时间：" + dt.toString(DF));
		System.out.println(dt.toString(DF) + (dt.isAfterNow() ? "晚" : "早") + "于当前");
		System.out.println("\n时间比较");
		Days days = Days.daysBetween(DateTime.now(), dt);
		int daysBetween = days.getDays();
		System.out.println(Math.abs(daysBetween) + "天以" + (daysBetween > 0 ? "后" : "前"));
		Weeks weeks = days.toStandardWeeks();
		int weeksBetween = weeks.getWeeks();
		System.out.println(Math.abs(weeksBetween) + "星期以" + (weeksBetween > 0 ? "后" : "前"));
	}

	/**
	 * withTime 指定时间
	 */
	@Test
	public void testSpicalGetter() {
		dt = dt.withTime(0, 0, 0, 0);
		System.out.println("今天凌晨：" + dt.toString(DF));
		
		dt = dt.withTime(23, 59, 59, 999);
		System.out.println("今天午夜：" + dt.toString(DF));
	}

	@After
	public void afterTest() {
		System.out.println("---------------------");
	}
}
