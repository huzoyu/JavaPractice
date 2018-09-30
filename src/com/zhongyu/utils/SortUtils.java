package com.zhongyu.utils;

/**
 * 排序工具类
 * @version 0.1
 * @author ZYHU
 * @date 2018-9-7 15:51:49
 *
 */
public class SortUtils {

	/**
	 * 现已支持排序类型:
	 * int array;
	 */
	public static int[] ret;
	private static int flag;
	private static int temp;
	
	/**
	 * int数组的快速排序
	 * @param nums
	 * @return
	 * @Test
	 */
	public static int[] quickSort(int[] nums) {
		ret = nums;
		quicksort(0, nums.length-1);
		return ret;
	}
	
	/**
	 * 快速排序迭代
	 * @param left
	 * @param right
	 */
	private static void quicksort (int left, int right) {
		if (left >= right) {
			return;
		}
		
		flag = ret[left];
		int i = left;
		int j = right;
		int t;
		
		while (i != j) {
			while (ret[j] > flag) {
				j--;
			}
			while (ret[i] < flag) {
				i++;
			}
			if (i < j) {
				exchange(i, j);
			}
		}
		
		exchange(left, i);
		
		for (int k : ret) {
			System.out.print(k+" ");
		}
		
		quicksort(left, i-1);
		quicksort(i+1, right);
		
		
	}
	
	/**
	 * 交换数组的第i\j个元素
	 * @param nums
	 * @param i
	 * @param j
	 * @return
	 */
	private static void exchange(int i, int j){
		temp = ret[j];
		ret[j] = ret[i];
		ret[i] = temp;		
	}
}
