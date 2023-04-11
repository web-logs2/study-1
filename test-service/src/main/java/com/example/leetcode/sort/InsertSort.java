package com.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author chenyile
 * @date 2023/2/8  14:09
 * @description:
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{10,1, 2, 3, 5, 6, 7, 4, 9, 8};
        int[] arr = new int[]{10, 1, 3, 2, 5, 7, 6, 8, 0};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void insert(int[] a) {
        //i代表待插入元素的索引
        for (int i = 1; i < a.length; i++) {
            int t = a[i];//代表待插入的元素值
            int j = i - 1;//代表已排序区域的元素索引
            while (j >= 0) {
                if (t < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
                j--;
            }
            a[j + 1] = t;
        }
    }
}
