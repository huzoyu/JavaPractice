package com.zhongyu.hu.upcasting;

import java.util.Random;

import com.zhongyu.utils.SortUtil;

public class Demo {

	//TODO
	public static void main(String[] args){
		quicksortTest(100000000);
		
	}
	
	public static void quicksortTest(int amount) {
		Random rd = new Random();
		int[] nums = new int[amount];
		for (int i = 0; i < amount; i++) {
			nums[i] = rd.nextInt(amount*2);
		}
		
		long startTime = System.currentTimeMillis();
		nums = SortUtil.quickSort(nums);
		long endTime = System.currentTimeMillis();
		
		for (int i : nums) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		float time = endTime - startTime;
		System.out.println(amount+"大小数组测试耗时：" + time + " ms");
	}
	
	public static void staticTest(){
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
