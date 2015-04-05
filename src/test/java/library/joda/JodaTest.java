package library.joda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Weeks;
import org.junit.Before;
import org.junit.Test;

public class JodaTest {

    Logger log = LogManager.getLogger(this.getClass());

    private DateTime dt;

    private static final String DF = "yyyy-MM-dd HH:mm:ss SSS";
    private static final String DFB = "%04d-%02d-%02d %02d:%02d:%02d %03d"; // date formate blank

    @Before
    public void beforeTest() {
        dt = new DateTime();
    }

    /**
     * 测试　Joda 的静态方法
     */
    @Test
    public void testStaticMethod() {
        log.debug("系统时间：" + DateTime.now().toString(DF));
    }

    /**
     * 测试 Joda 的成员方法
     * 特别的说一下 {@link String#formate(String, Object...)} 方法：
     *      该方法输入两个参数：第一个参数为格式，格式的描述使用了类似 C 语言的占位符；
     *      其后的变长数组为需要填充到格式（第一个参数中的内容）
     *
     *      一些常用的占位符：
     *      %s -> 字符串；
     *      %d -> 整数；
     *      %o -> 八进制整数；
     *      %x -> 十六进制整数；
     *      %h -> 散列值；
     *      %% -> 百分比；
     *      %n -> 换行符；
     *      %c -> 字符；
     *      %b -> 布尔；
     *
     *      类似 printf() 的方法有 System.out.printf(Object)；
     */
    @Test
    public void testGetter() {

        int year = dt.getYear();
        int month = dt.getMonthOfYear();
        int day = dt.getDayOfMonth();
        int hour = dt.getHourOfDay();
        int minute = dt.getMinuteOfHour();
        int second = dt.getSecondOfMinute();
        int millis = dt.getMillisOfSecond();

        String datetime = String.format(DFB, year, month, day, hour, minute, second, millis);

        log.debug("系统当前时间：" + datetime);
        log.debug(String.format("今天是%04d年的第%03d天", year, dt.getDayOfYear()));

    }

    /**
     * 时间计算
     */
    @Test
    public void testCalc() {
        dt = dt.plusYears(-2);
        log.debug("===> 2年前");
        log.debug("具体时间：" + dt.toString(DF));

        dt = dt.plusDays(4);
        log.debug("===> ４天后");
        log.debug("具体时间：" + dt.toString(DF));

        dt = dt.plusYears(3);
        log.debug("===> 3年后");
        log.debug("具体时间：" + dt.toString(DF));
        log.debug(dt.toString(DF) + (dt.isAfterNow() ? "晚" : "早") + "于当前");

        dt = dt.minusDays(400);
        log.debug("===> 400天前");
        log.debug("具体时间：" + dt.toString(DF));
        log.debug(dt.toString(DF) + (dt.isAfterNow() ? "晚" : "早") + "于当前");
        log.debug("\n时间比较");
        Days days = Days.daysBetween(DateTime.now(), dt);
        int daysBetween = days.getDays();
        log.debug(Math.abs(daysBetween) + "天以" + (daysBetween > 0 ? "后" : "前"));
        Weeks weeks = days.toStandardWeeks();
        int weeksBetween = weeks.getWeeks();
        log.debug(Math.abs(weeksBetween) + "星期以" + (weeksBetween > 0 ? "后" : "前"));
    }

    /**
     * withTime 指定时间
     */
    @Test
    public void testSpicalGetter() {
        dt = dt.withTime(0, 0, 0, 0);
        log.debug("今天凌晨：" + dt.toString(DF));

        dt = dt.withTime(23, 59, 59, 999);
        log.debug("今天午夜：" + dt.toString(DF));
    }

}
