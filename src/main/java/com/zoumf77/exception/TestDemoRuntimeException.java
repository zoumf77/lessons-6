package com.zoumf77.exception;

public class TestDemoRuntimeException {
	
	/**
	 * 因为DemoRuntimeException是RuntimeException，所以方法可以没有throws子句
	 */
	public static void method1(){
		throw new DemoRuntimeException("This is Runtime subclass");
	}
	
	public static void method2(){
		method1();
	}
	
	public static void method3(){
		method2();
	}
	
	
	public static void main(String[] args){
		method1();
	}
	
	/*public static void main(String[] args){
		try{
			method3();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}*/
}
