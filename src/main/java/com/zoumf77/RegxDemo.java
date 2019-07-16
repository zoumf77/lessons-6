package com.zoumf77;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 可以参考：https://www.cnblogs.com/xyou/p/7427779.html
 */
public class RegxDemo {
	public  static void main(String[] args){
		/*匹配一个字符串是不是数字字符串*/
		/*这个Pattern.compile返回一个Pattern实例，体现了用静态工厂方法代替构造函数的模式，Pattern的构造函数被私有
		 * 具体可阅读Effective Java(Joshua Bloch)，中文俞黎敏翻译
		 */
		Pattern pattern=Pattern.compile("^-?\\d+(\\.\\d+)?$");
		Matcher matcherNumber=pattern.matcher("123456.12");
		System.out.println("123456.12是不是一个数字串="+matcherNumber.matches());
		
		
		Matcher matcherString=pattern.matcher("123456gfggf");
		System.out.println("123456gfggf是不是一个数字串="+matcherString.matches());
		
		
	    /*zmf单词开口结尾*/
		
		find("\\bzmf\\b","zmf is a student,zmfmay is a engineer");
		
		
		/*饥饿的、贪心的区别
		 * ？，表示非贪心的
		 * *、+、{n}、{n,}、{n,m}后边
		 * o+，就是贪心的，尽可能多
		 */
		
		
		
		String regex="o+";
		String s2="oooofooooo";
		System.out.println("====我是贪心的 分隔符=====");
		find(regex,s2);
		System.out.println("====我是非贪心的 分隔符=====");
		regex="o+?";
		find(regex,s2);
		
		
		
		/*电子邮件正则表达式
		https://www.cnblogs.com/zcbing/p/6545209.html
		*/
		
		Pattern pattern4=Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
		String s3="zzz@sina.com.cn";
		Matcher matcherEmail=pattern4.matcher(s3);
		
		System.out.println(" if the "+s3+" is legal email address?"+matcherEmail.find());
		
		String s4="zzz.may@sina.com";
		matcherEmail=pattern4.matcher(s4);
		System.out.println(" if the "+s4+" is legal email address?"+matcherEmail.find());
		
		/*
		 * 分组
		 */
		Pattern pattern5=Pattern.compile("(\\d\\d)\\1");
		Matcher matcher5=pattern5.matcher("1212");
		System.out.println("(\\d\\d).count="+matcher5.groupCount());
		
		
		System.out.println("=====我是边界分隔符=======");
		find("\\Gdog","dogdog");
	}

	public static void find(String regex,String s){
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(s);
		while(matcher.find()){
			int start=matcher.start();
			int end=matcher.end();
			
			System.out.println("start="+start+";end="+end+"串为:"+s.substring(start, end));
		
		}
		
	}
}
