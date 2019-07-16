package com.zoumf77.exception;

@SuppressWarnings("serial")
/*抛出运行时异常时，编译器是不会提示使用try的*/
public class NotNeedCheckException extends RuntimeException{

	public String getMessage(){
		return "notNeed";
	}
}
