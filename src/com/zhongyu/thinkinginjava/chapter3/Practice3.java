package com.zhongyu.thinkinginjava.chapter3;

/**
 * 演示Java的方法别名机制
 * @author ZYHU
 *
 */

public class Practice3 {
	
	static Boy alex = new Boy();
	
	static Boy nickname(Boy boy){
		return boy = alex;
	}
	
	public static void main(String[] args){
		Boy alexander = new Boy();
		alex.age++;
		System.out.println(alexander.age);
		System.out.println(alex.age);
		
		alexander = nickname(alexander);
		System.out.println(alexander.age);
		System.out.println(alex.age);
		
		alex.age++;
		System.out.println(alexander.age);
		System.out.println(alex.age);
		
	}
}

class Boy{
	float age = 15;
}

