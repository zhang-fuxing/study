package com.zfx.util.date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author zhouhao
 * @brief 数据库使用的10位时间戳与日期字符串转换工具类
 * @date 2021-04-08
 */
public class DateUtils {
    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (null == seconds || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (null == format || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.parseLong(seconds + "000")));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param dateStr 字符串日期
     */
    public static String date2TimeStamp(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        return String.valueOf(time / 1000);
    }

    /**
     * @param beginDate 起始日期
     * @param limitDay  时限天数
     * @brief 获取指定时限对应的日期, 输入输出都是java.util.Date
     */
    public static java.util.Date getLimitDate(java.util.Date beginDate, int limitDay) {
        if (null == beginDate) {
            return null;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(beginDate);
        calendar.add(Calendar.DATE, limitDay);
        return calendar.getTime();
    }

    /**
     * 传入一个java日期对象，得到一个格式化为年-月-日的字符串日期
     *
     * @param date 日期对象
     * @return 日期字符串
     */
    public static String formatToYmd(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date == null)
            return "";
        return sdf.format(date);
    }

    public static String format(java.util.Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss SSS");
    }

    public static String format(java.util.Date date, String pattern) {
        if (date == null)
            return "";
        SimpleDateFormat sdf;
        if (StrUtil.isBlank(pattern))
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        else
            sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    static String requireNonNullElseGet(String str, String def) {
        return StrUtil.isBlank(str) ? def : str;
    }
    
    public static String currentMonthFirstDay(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(requireNonNullElseGet(pattern, "yyyy-MM-dd hh:mm:ss"));
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return format.format(c.getTime());
    }

    public static String format(String date, String pattern) {
        if (StrUtil.isBlank(date)) return null;
        SimpleDateFormat format = new SimpleDateFormat(requireNonNullElseGet(pattern, "yyyy-MM-dd hh:mm:ss"));
        return format.format(DateUtil.parse(date));
    }

    public static int thisMonth(){
        return LocalDate.now().getMonthValue();
    }

    public static LocalDate parse(@NotNull String str,@NotNull String pattern) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern(pattern));
    }
    
    public static LocalDateTime parseT(@NotNull String str,@NotNull String pattern) {
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(pattern));
    }
    public static LocalDateTime parseT(@NotNull String str) {
        return parseT(str, "yyyy-MM-dd hh:mm:ss SSS");
    }
    
    
    public static LocalDate parse(@NotNull String str) {
        LocalDate date = null;
        List<String> list = List.of("yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd", "yyyy MM dd", "yyyy.MM.dd", "yyyy年MM月dd日");
        for (String pattern : list) {
            try {
                date = parse(str, pattern);
                break;
            } catch (Exception ignored) {}
        }
        return date;
    }

    public static java.util.Date localDateTimeToDate(@NotNull LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static java.util.Date localDateToDate(@NotNull LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static java.util.Date localTimeToDate(@NotNull LocalTime localTime) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
        return localDateTimeToDate(localDateTime);
    }
    public static LocalDateTime dateToLocalDateTime(@NotNull java.util.Date date) {
        return getZoneDateTime(date).toLocalDateTime();
    }

    public static LocalDate dateToLocalDate(@NotNull java.util.Date date) {
        return getZoneDateTime(date).toLocalDate();
    }

    public static LocalTime dateToLocalTime(@NotNull java.util.Date date) {
        return getZoneDateTime(date).toLocalTime();
    }
    private static ZonedDateTime getZoneDateTime(@NotNull java.util.Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault());
    }
    
    public static java.util.Date getDateOffset(java.util.Date date, long offset, TemporalUnit unit) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        localDateTime = localDateTime.plus(offset, unit);
        return localDateTimeToDate(localDateTime);
    }
    
    /**
     * 获取偏移后的日期，默认时间单位是分钟
     * @param date 从哪个时间点偏移，例如现在
     * @param offset 偏移多少
     * @return 偏移后的时间
     */
    public static java.util.Date getDateOffset(java.util.Date date, long offset) {
        return getDateOffset(date, offset, ChronoUnit.MINUTES);
    }
    
    /**
     * 偏移3600分钟后的时间
     *
     * @param date 偏移时间点
     * @return  偏移后的时间
     */
    public static java.util.Date getDateOffset(java.util.Date date) {
        return getDateOffset(date, 3600);
    }
}
