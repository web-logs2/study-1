package com.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author chenyile
 * @date 2023/2/8  13:05
 * @description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{10,1, 2, 3, 5, 6, 7, 4, 9, 8};
        int[] arr = new int[]{10, 1, 3, 2, 5, 7, 6, 8, 0};
        bubble2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void bubble2(int[] arr) {
        int n = arr.length - 1;
        while (true) {
            int last = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    last = j;
                }
            }
            n = last;
            if (n == 0) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
