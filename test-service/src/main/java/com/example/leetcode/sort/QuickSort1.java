package com.example.leetcode.sort;

import java.util.Arrays;

import static com.example.leetcode.sort.InsertSort.swap;

/**
 * @author chenyile
 * @date 2023/2/8  16:02
 * @description: 单边循环快排
 */
public class QuickSort1 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4, 6, 5, 8, 7, 9};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }
        int p = partition(arr, l, h);
        quick(arr, l, p - 1);
        quick(arr, p + 1, h);
    }

    public static int partition(int[] arr, int l, int h) {
        int i = l;
        for (int j = l; j < h; j++) {
            if (arr[j] < arr[h]) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, h, i);
        return i;
    }
}
