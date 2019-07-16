package com.zoumf77;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
	public  static void main(String[] args){
		
		
		Float f3=new Float(5.55);
		Float f4=new Float(2.15);
		System.out.println("5.55*2.15="+(f3*f4));
		
		float   f5=0.1f;
		
		System.out.println("=====浮点直接运算======");
		System.out.println("0.2+0.1="+(0.2+0.1));
		System.out.println("0.3-0.1="+(0.3-0.1));
		System.out.println("0.2*0.1="+(0.2*0.1));
		
		System.out.println("=====BigDecimal=====");
		System.out.println("0.2+0.1="+new BigDecimal("0.2").add(BigDecimal.valueOf(0.1)).toString());
		System.out.println("0.3-0.1="+new BigDecimal("0.3").subtract(BigDecimal.valueOf(0.1)).toString());
		System.out.println("0.2*0.1="+new BigDecimal("0.2").multiply(BigDecimal.valueOf(0.1)).toString());
		
		Double d1=4.015;
		Double d2=100d;
		System.out.println("======double=====");
		System.out.println("4.105*100="+(d1*d2));
		System.out.println("=====BigDecimal=====");
		System.out.println("4.105*100="+new BigDecimal("4.105").multiply(BigDecimal.valueOf(100)).toString());
		
		
		//用double调用构造函数
		System.out.println("BigDecimal用 double作为参数生成一个实例");
		BigDecimal b=new BigDecimal(2.3);
		System.out.println("2.3="+b);
		
		//用字符串调用构造函数
		System.out.println("BigDecimal用 字符串作为参数生成一个实例");
		BigDecimal b0=new BigDecimal("2.3");
		System.out.println("\"2.3\"="+b0);
		
		//或者用valueof生成一个BigDecimal的实例
		BigDecimal b1=BigDecimal.valueOf(2.3);
		System.out.println("valueOf(2.3)="+b1);
		
		
		
		BigDecimal b2=BigDecimal.valueOf(2.14567);
		System.out.println(b2.setScale(3, RoundingMode.UP));
		
		
	}
}
