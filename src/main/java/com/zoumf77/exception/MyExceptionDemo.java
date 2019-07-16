package com.zoumf77.exception;

import java.util.regex.Pattern;

public class MyExceptionDemo {

	public boolean isInt(String aNumber) throws IsNotIntException{
		
		  Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	      boolean is=pattern.matcher(aNumber).matches();  
	      if (is) return is;
	      else throw new IsNotIntException();
	}
	
	public static void main(String[] args){
		String aNumber="1";
        MyExceptionDemo myex=new MyExceptionDemo();
        try {
			if(myex.isInt(aNumber)){
				System.out.println("是一个整型");
			}
		} catch (IsNotIntException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
        String aNumber1="1.xx";
        try {
			if(myex.isInt(aNumber1)){
				System.out.println("是一个整型");
			}
		} catch (IsNotIntException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
        
        
        myex.notneedcatch();
        
      
	}
	
	public void notneedcatch() throws NotNeedCheckException {
		throw new NotNeedCheckException();
	}
}
