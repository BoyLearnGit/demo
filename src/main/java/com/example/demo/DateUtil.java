package com.example.demo;

import org.apache.tomcat.jni.Local;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @Desc jdk1.8时间工具
 * @Author lyl
 * @Date 2019/5/17 10:06
 **/
public class DateUtil {

    /**
     * 获取当前时间的时间戳
     * @param second true 秒 false 毫秒
     * @return
     */
    public static long getCurrentTimeLong(boolean second){
        if(second){
            return Instant.now().getEpochSecond();
        }else {
            return Instant.now().toEpochMilli();
        }
    }

    /**
     * 获取指定时间的时间戳
     * @param date
     * @param second true 秒 false 毫秒
     * @return
     */
    public static long getTimeLong(Date date, boolean second){
        Instant instant=date.toInstant();
        if(second){
            return instant.getEpochSecond();
        }else {
            return instant.toEpochMilli();
        }
    }

    /**
     * 获取当前时间，时间格式为yyyy-MM-dd
     * @return
     */
    public static String getCurrentLocalDate(String pattern){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }
    /**
     * 获取当前时间，时间格式为HH:mm:ss
     * @return
     */
    public static String getCurrentLocalTime(String pattern){
        return  LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }
    /**
     * 获取当前时间，时间格式为yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentLocalDateTime(String pattern){
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取指定年份,指定天数的日期
     * @param year
     * @param day
     * @return
     */
    public static LocalDate getLocalDate(int year,int day){
        return LocalDate.ofYearDay(year, day);
    }

    /**
     * 获取当前时间的年
     * @return
     */
    public static int getCurrentYear(){
        return LocalDate.now().getYear();
    }
    /**
     * 获取指定时间的年
     * @return
     */
    public static int getYear(LocalDate localDate){
        return localDate.getYear();
    }
    /**
     * 获取当前时间的月份
     * @return
     */
    public static int getCurrentMonth(){
        return LocalDate.now().getMonth().getValue();
    }
    /**
     * 获取指定时间的月份
     * @return
     */
    public static int getMonth(LocalDate localDate){
        return localDate.getMonth().getValue();
    }
    /**
     * 获取当前时间的日期
     * @return
     */
    public static int getCurrentMonthDay(){
        return LocalDate.now().getDayOfMonth();
    }
    /**
     * 获取指定时间的日期
     * @return
     */
    public static int getMonthDay(LocalDate localDate){
        return localDate.getDayOfMonth();
    }
    /**
     * 获取当前时间到年初的天数
     * @return
     */
    public static int getCurrentYearDay(){
        return LocalDate.now().getDayOfYear();
    }
    /**
     * 获取指定时间到年初的天数
     * @return
     */
    public static int getYearDay(LocalDate localDate){
        return localDate.getDayOfYear();
    }
    /**
     * 获取当前时间的星期
     * @return
     */
    public static int getCurrentWeekDay(){
        return LocalDate.now().getDayOfWeek().getValue();
    }
    /**
     * 获取指定时间的星期
     * @return
     */
    public static int getWeekDay(LocalDate localDate){
        return localDate.getDayOfWeek().getValue();
    }

    /**
     * 是否为闰年
     * @param localDate
     * @return
     */
    public static boolean leapYear(LocalDate localDate){
        return localDate.isLeapYear();
    }

    /**
     * 给指定时间新增或减少指定年月日周的时间
     * @param localDate
     * @param type 1年 2月 3日 4周
     * @param day
     * @return
     */
    public static LocalDate addDate(LocalDate localDate,int type,int day){
        switch (type){
            case 1:
                localDate=localDate.plusYears(day);
                break;
            case 2:
                localDate=localDate.plusMonths(day);
                break;
            case 3:
                localDate=localDate.plusDays(day);
                break;
            case 4:
                localDate=localDate.plusWeeks(day);
                break;
                default:
                    break;
        }
        return localDate;
    }




    public static void main(String[] args) {
//        System.out.println(getCurrentTimeLong(true));
//        System.out.println(getCurrentTimeLong(false));
//        System.out.println(getTimeLong(new Date(),true));
//        System.out.println(getTimeLong(new Date(),false));
//        System.out.println(getCurrentLocalDateTime("yyyy-MM"));
//        System.out.println(getLocalDate(2019,100));
        System.out.println(addDate(LocalDate.now(),4,1));
    }
}
