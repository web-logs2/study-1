package com.example.leetcode.leetcode;

import java.util.Stack;

/**
 * @author chenyile
 * @date 2023/2/5  23:59
 * @description:
 */


public class Offer30 {
    Stack<Long> stack;
    Long min;

    /**
     * initialize your data structure here.
     */
    public Offer30() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0l);
            min = Long.valueOf(x);
        } else {
            stack.push((long) (x - min));
            min = Math.min(x, min);
        }
    }

    public void pop() {
        if (stack.peek() < 0) {
            min = min - stack.pop();
            return;
        }
        stack.pop();
    }

    public int top() {
        if (stack.peek() > 0) {
            return (int) (min + stack.peek());
        } else {
            return Math.toIntExact(min);
        }
    }

    public int min() {
        return Math.toIntExact(min);
    }

    public static void main(String[] args) {
        Offer30 offer30 = new Offer30();
        offer30.push(3);
        offer30.push(2);
        offer30.push(1);
        offer30.push(5);
        offer30.push(-1);
        offer30.push(4);
        System.out.println(offer30.min());
        offer30.pop();
        System.out.println(offer30.min());
        offer30.pop();
        System.out.println(offer30.min());
    }
}
