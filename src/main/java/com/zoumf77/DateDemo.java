package com.zoumf77;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

public class DateDemo {
	
	public static void main(String[] args){
		
		
		System.out.println("Friday是星期几="+DayOfWeek.FRIDAY);
		
		System.out.println("一个星期的第一天是星期几="+DayOfWeek.of(1));
		
		System.out.println("12的英文="+Month.DECEMBER);
		
		System.out.println("December="+Month.valueOf("DECEMBER"));
		
		LocalDate date=LocalDate.of(2018, Month.NOVEMBER, 28);
		
		System.out.printf("LocalDate(2018/11/28) For the date of %s.%n",  date);
		
		YearMonth yearmonth= YearMonth.now();
		System.out.printf("当前年月及天数%s: %d%n", yearmonth, yearmonth.lengthOfMonth());
		
		Month month=yearmonth.getMonth();
		System.out.printf("当前月%s%n",yearmonth.getMonthValue());
		
		
		MonthDay monthday = MonthDay.of(Month.FEBRUARY, 29);
		System.out.println( "2020是不是有29天=？"+monthday.isValidYear(2020));
		
		System.out.println("2012 is leapyear:"+Year.of(2012).isLeap());
		
		LocalTime localtime=LocalTime.now();
		System.out.println("现在时间="+localtime.getHour()+":"+localtime.getMinute()+":"+localtime.getSecond());
		
		System.out.printf("now: %s%n", LocalDateTime.now());
		
		Instant timestamp = Instant.now();
		
		System.out.println("当前格林威治时间="+timestamp.toString());
		
		Long now=System.nanoTime();
		System.out.println("纳秒="+now);
		System.out.println("秒="+timestamp.getEpochSecond());
	}
	
}
