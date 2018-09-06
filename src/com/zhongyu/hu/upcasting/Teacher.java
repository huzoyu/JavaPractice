package com.zhongyu.hu.upcasting;

public class Teacher extends People{

	@Override
	protected String getId(){
		return this.name+this.year;
	}
}
