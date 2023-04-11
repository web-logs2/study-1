package com.example.leetcode.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author chenyile
 * @date 2023/2/5  23:09
 * @description:
 */
public class Offer09 {
    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();

    public void push(int val) {
        stackIn.push(val);
    }

    public int pop() {
        if(stackOut.isEmpty()){
            if(stackIn.isEmpty()){
                return -1;
            }else{
                while(!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
            }
        }
        return stackOut.pop();
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        System.out.println(stack1.pop());
    }
}
