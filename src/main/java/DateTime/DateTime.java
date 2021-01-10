package DateTime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

/**
jdk8之前的api
    Date util

    Date sql 数据库中的日期类型的变量
        sql转换util 多态
        util转换sql
    SimpleDateFormat
 */
public class DateTime {
    @Test
    public void test(){
        long time = System.currentTimeMillis();//返回现在时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }

    @Test
    public void test2(){
        //无参构造器 创建一个对应当前时间的Date对象
        Date date = new Date();//Fri Jul 31 20:06:46 CST 2020
        System.out.println(date.toString());//显示年月时分秒
        System.out.println(date.getTime());//获取当前date对象的时间戳

        //带参构造器 创建指定毫秒数的Date对象
        Date date1 = new Date(1596197471532L);
        System.out.println(date1.toString());
    }

    @Test
    public void test4(){

        //sql转换util 多态
        Date date = new java.sql.Date(31212121212L);
        //util转换sql 不能强转
        java.sql.Date date2 =new java.sql.Date(date.getTime());

    }

    //格式化 日期--字符串  解析 字符串--日期
    @Test
    public void test3() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);

        //格式化
        String format = formatter.format(date);
        System.out.println(format);

        //解析
        Date date1 = formatter.parse(format);
        System.out.println(date1);

    }

    //构造器格式化 按指定方式格式化
    @Test
    public void test5() throws ParseException {
        Date date = new Date();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MMMM.dd GGG hh:mm aaa");//2020-08-01 公元07-35:41
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm:ss");//2020-08-01 07-35:41
        String s = dateFormat.format(date);
        System.out.println(s);

        //解析 需要注意时间格式
        Date date1 = dateFormat.parse("2020-08-01 07-35:41");//Sat Aug 01 07:35:41 CST 2020
        System.out.println(date1);
    }

    //日历类
    @Test
    public void test6(){
        //方法一 因为Calendar是抽象类 所以实例化需要用子类
        //Calendar calendar = new GregorianCalendar();
        //也可以直接调用静态方法getInstance
        Calendar calendar1 = Calendar.getInstance();

        //get 获取今天是本月的第几号
        int day = calendar1.get(Calendar.DAY_OF_MONTH);
        int year = calendar1.get(Calendar.WEEK_OF_YEAR);
        System.out.println(day);
        System.out.println(year);

        //set 修改属性
        calendar1.set(Calendar.DAY_OF_MONTH,22);

        //add 加几天
        calendar1.add(Calendar.DAY_OF_MONTH,3);

        //getTime 日历------>date
        Date date = calendar1.getTime();
        System.out.println(date);

        //setTime date------>日历
        Date date1 = new Date();
        calendar1.setTime(date1);

    }

    //localTime localDate localDateTime jdk8后使用 类似于Calendar
    @Test
    public void test7(){
        //now（）获取当前时间日期
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
    }

    //本初子午线时间 instant
    @Test
    public void test8(){
        Instant instant = Instant.now();
        OffsetDateTime offsetDateTime  = instant.atOffset(ZoneOffset.ofHours(8));//加8个时区等于本地时间
        System.out.println(offsetDateTime);
        //获取毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //毫秒数转换为时间
        Instant instant1 = Instant.ofEpochMilli(1596369392248L);
        System.out.println(instant1);
    }

    // DateTimeFormatter 和 SimpleDateFormat 用法一致
    @Test
    public void test9(){
        //预定的标准格式
        //本地化相关的格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(str);
        //自定义格式
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM--dd");
        String str1 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(str1);
    }

















}
