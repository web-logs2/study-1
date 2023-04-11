package com.example.leetcode.sort2;

import java.util.Arrays;

/**
 * @author chenyile
 * @date 2023/2/10  20:22
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 1};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArray(int[] nums) {
        bubble(nums);
        return nums;
    }

    public static void bubble(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean swapped = false;
            for (int j = i; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
