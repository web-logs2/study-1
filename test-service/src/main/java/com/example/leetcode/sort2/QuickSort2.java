package com.example.leetcode.sort2;

import java.util.Arrays;

/**
 * @author chenyile
 * @date 2023/2/10  19:34
 * @description:
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 4, 7, 6, 5};
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
        int pv = arr[l];
        int i = l;
        int j = h;
        while (i < j) {
            while (i < j && arr[j] > pv) {
                j--;
            }
            while (i < j && arr[i] <= pv) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
