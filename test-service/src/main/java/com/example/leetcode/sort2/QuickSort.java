package com.example.leetcode.sort2;

import java.util.Arrays;

/**
 * @author chenyile
 * @date 2023/2/9  16:57
 * @description:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4, 7, 6, 5};
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
        swap(arr, i, h);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
