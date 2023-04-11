package com.example.leetcode.sort;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * @author chenyile
 * @date 2023/2/8  13:48
 * @description:
 */
public class SelctionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 6, 7, 4, 9, 8};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int s = i;
            for (int j = s + 1; j < arr.length; j++) {
                if (arr[s] > arr[j]) {
                    s = j;
                }
            }
            if (i != s) {
                swap(arr, i, s);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
