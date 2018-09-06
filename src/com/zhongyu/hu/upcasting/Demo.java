package com.zhongyu.hu.upcasting;

public class Demo {
	
	public static void main(String[] args){
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		System.out.println(st1.i);
		System.out.println(st2.i);
		System.out.println(StaticTest.i);
		
		StaticTest.i++;
		System.out.println(st1.i);
		System.out.println(st2.i);
		System.out.println(StaticTest.i);
		
		st1.i++;
		System.out.println(st1.i);
		System.out.println(st2.i);
		System.out.println(StaticTest.i);
		
		st2.i++;
		System.out.println(st1.i);
		System.out.println(st2.i);
		System.out.println(StaticTest.i);
	}
	
	protected String getId(People people){
		return people.getId();
	}

}
