package com.example.leetcode.linkedList;

/**
 * @author chenyile
 * @date 2022/12/19  14:29
 * @description:
 */
public class LeetCode203 {
    public static ListNode removeElements(ListNode head, int val) {
        //处理头节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.next.val == val) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        return head;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    public static ListNode removeElements3(ListNode head, int val) {
        //if (head == null) {
        //    return null;
        //}
        //ListNode res = removeElements3(head.next, val);
        //if (head.val == val) {
        //    return res;
        //} else {
        //    head.next = res;
        //    return head;
        //}
        if (head == null) {
            return null;
        }
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 4};
        ListNode listNode = new ListNode(arr);
        removeElements2(listNode, 3);
        removeElements3(listNode, 2);
        System.out.println(listNode);
    }
}
