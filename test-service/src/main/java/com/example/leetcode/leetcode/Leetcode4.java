package com.example.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * @author chenyile
 * @date 2023/2/11  14:25
 * @description:一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,3,4,5,6,7,8,9]
 * 输出: 8
 */
public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        if (i == nums1.length) {
            while (j < nums2.length) {
                list.add(nums2[j]);
                j++;
            }
        }
        if (j == nums2.length) {
            while (i < nums1.length) {
                list.add(nums1[i]);
                i++;
            }
        }
        return findListMedian(list);
    }

    public double findListMedian(List<Integer> list) {
        int mid = (list.size() - 1) / 2;
        return mid % 2 == 0 ? (list.get(mid) + list.get(mid + 1) + 0.0) / 2 : list.get(mid) + 0.0;
    }

    public static void main(String[] args) {
        CyclicBarrier cb=new CyclicBarrier(3);
        Leetcode4 leetcode4 = new Leetcode4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println(leetcode4.findMedianSortedArrays(nums1, nums2));
    }
}