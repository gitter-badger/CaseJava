package lib.joda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Weeks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JodaTest {

    Logger log = LogManager.getLogger(this.getClass());

    private DateTime dt;

    private final String YYYY_MM_DD = "yyyy-MM-dd";
    private final SimpleDateFormat F_YMD = new SimpleDateFormat(YYYY_MM_DD);
    private final SimpleDateFormat F_E = new SimpleDateFormat("E");
    private final SimpleDateFormat F_Y = new SimpleDateFormat("YYYY");
    private final SimpleDateFormat F_H = new SimpleDateFormat("HH");

    private static final String DF = "yyyy-MM-dd HH:mm:ss SSS";
    private static final String DFB = "%04d-%02d-%02d %02d:%02d:%02d %03d"; // date formate blank

    @Before
    public void beforeTest() {
        dt = new DateTime();
    }

    /**
     * 测试 Joda 的静态方法
     */
    @Test
    public void testStaticMethod() {
        log.debug("系统时间：" + DateTime.now().toString(DF));
    }

    /**
     * 测试 Joda 的成员方法
     * 特别的说一下 {@link String#format(String, Object...)} 方法：
     *      该方法输入两个参数：第一个参数为格式，格式的描述使用了类似 C 语言的占位符；
     *      其后的变长数组为需要填充到格式（第一个参数中的内容）
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

    @Test
    public void test() {
        Date _now = new Date();
        DateTime source = new DateTime(0);
        DateTime now = new DateTime();
        // Assert.assertTrue(now.toDate().getTime() - _now.getTime() > 0);
        Assert.assertEquals(source.toString(YYYY_MM_DD), "1970-01-01");
        // 格式化时间
        Assert.assertEquals(F_YMD.format(_now), now.toString(YYYY_MM_DD));
        // 剖析 - 这里就直接使用过时的方法
        Assert.assertEquals(WeekDay.toText(now.getDayOfWeek()) + "", F_E.format(_now));
        Assert.assertEquals(now.getYearOfCentury(), Integer.valueOf(F_Y.format(_now)) % 100);
        // Assert.assertEquals(now.getHourOfDay(), Long.valueOf(F_H.format(_now)));
        // 计算 - 测试代码
        for (int i = 0; i < 7; i++) {
            Assert.assertEquals(WeekDay.toText(i + WeekDay.getOffset()), F_E.format(now.plusDays(i).toDate()));
        }
        DateTime feb30 = source.plusYears(now.getYear() - source.getYear()).plusMonths(1).plusDays(30);
        System.out.println(feb30.toString(YYYY_MM_DD));
        System.out.println(feb30.plusMonths(1).minusMonths(1).toString(YYYY_MM_DD));
    }

    enum WeekDay {
        星期日(0),
        星期一(1),
        星期二(2),
        星期三(3),
        星期四(4),
        星期五(5),
        星期六(6);

        private int code;

        WeekDay(int code) {
            this.code = code;
        }

        public static String toText(int code){
            for (WeekDay weekDay : WeekDay.values()) {
                if(weekDay.code == code % 7){
                    return weekDay.name();
                }
            }
            return "";
        }

        public static int getOffset(){
            String name = new SimpleDateFormat("E").format(new Date());
            for (WeekDay weekDay : WeekDay.values()) {
                if(weekDay.name().equals(name)){
                    return weekDay.code;
                }
            }
            return -1;
        }
    }

    // Apache Commons Lang 快速趋势分秒的方法
    // DateUtils.truncate(new Date(), Calendar.DATE);
}
