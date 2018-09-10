package com.zhongyu.utils;

public class SortUtil {

	public static int[] ret;
	
	public static int[] quickSort(int[] nums) {
		quicksort(nums, 0, nums.length-1);
		return nums;
	}

	//TODO
	public static void quicksort(int[] a, int left, int right) {
		// 如果left等于right，即数组只有一个元素，直接返回
		if (left >= right) {
			return;
		}
		// 设置最左边的元素为基准值
		int key = a[left];
		// 数组中比key小的放在左边，比key大的放在右边，key值下标为i
		int i = left;
		int j = right;
		while (i < j) {
			// j向左移，直到遇到比key小的值
			while (a[j] >= key && i < j) {
				j--;
			}
			// i向右移，直到遇到比key大的值
			while (a[i] <= key && i < j) {
				i++;
			}
			// i和j指向的元素交换
			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		a[left] = a[i];
		a[i] = key;
		quicksort(a, left, i - 1);
		quicksort(a, i + 1, right);
	}
}