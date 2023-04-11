package com.example.leetcode;

import java.util.List;

/**
 * @author chenyile
 * @date 2022/12/19  14:13
 * @description:
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //使用arr为参数创建一个ListNode,当前的ListNode为链表的头节点
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val).append("->");
            cur = cur.next;
        }
        res.append("NUll");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 4};
        ListNode listNode = new ListNode(arr);
        removeElements(listNode,2);
        System.out.println(listNode);
    }

    public static ListNode removeElements(ListNode head, int val) {
        //处理头节点
        while(head !=null && head.val==val){
            head=head.next;
        }
        if(head==null){
            return null;
        }
        ListNode tempNode=head;
        while(tempNode.next!=null){
            if(tempNode.next.val==val){
                tempNode.next=tempNode.next.next;
            }else{
                tempNode=tempNode.next;
            }
        }
        return head;
    }
}
