package com.zhongyu.utils.string2hex;

import java.util.Scanner;

/**
 * 两字节字符串格式化为16进制格式
 * 
 * @author ZYHU
 *
 */

public class String2Hex {

	public static void main(String[] args){
		new String2Hex().toHex();
	}

	private String str;
	private String result;
	
	private void toHex(){
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		System.out.println("回车结束运行。");
		while(!str.isEmpty()){
			result = "0x" + str + ", ";
			System.out.print(result);
			str = sc.nextLine();
		}
		sc.close();
	}
	
}
