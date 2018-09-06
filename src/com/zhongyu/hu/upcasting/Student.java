package com.zhongyu.hu.upcasting;

public class Student extends People{

	@Override
	protected String getId(){
		return this.year+this.number+this.name;
	}
}
