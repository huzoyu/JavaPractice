package com.zhongyu.hu.upcasting;

public class Admin extends People{
	

	@Override
	protected String getId(){
		return this.name;
	}
}
