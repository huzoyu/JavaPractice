package com.zhongyu.utils;

public class SortUtil {

	public static int[] ret;
	
	public static int[] quickSort(int[] nums) {
		quicksort(nums, 0, nums.length-1);
		return nums;
	}

	//TODO
	public static void quicksort(int[] a, int left, int right) {
		// ���left����right��������ֻ��һ��Ԫ�أ�ֱ�ӷ���
		if (left >= right) {
			return;
		}
		// ��������ߵ�Ԫ��Ϊ��׼ֵ
		int key = a[left];
		// �����б�keyС�ķ�����ߣ���key��ķ����ұߣ�keyֵ�±�Ϊi
		int i = left;
		int j = right;
		while (i < j) {
			// j�����ƣ�ֱ��������keyС��ֵ
			while (a[j] >= key && i < j) {
				j--;
			}
			// i�����ƣ�ֱ��������key���ֵ
			while (a[i] <= key && i < j) {
				i++;
			}
			// i��jָ���Ԫ�ؽ���
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