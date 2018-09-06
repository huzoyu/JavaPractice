package com.zhongyu.hu.upcasting;

public class People {

	protected int year;
	protected int number;
	protected String name;
	protected String id;
	
	People(){
		
	}
	
	People(int year,int number,String name){
		this.year = year;
		this.number = number;
		this.name = name;
	}
	
	protected String getId(){
		id = "!!!";
		return id;
	}
}
