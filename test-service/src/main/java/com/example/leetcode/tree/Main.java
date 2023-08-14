package com.example.leetcode.tree;


import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chenyile
 * @date 2023/2/4  19:57
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1, "a");
        tree.put(3, "b");
        tree.put(2, "c");
        tree.put(10, "h");
        tree.put(7, "j");
        System.out.println(tree.middleErgodic());
        System.out.println(tree.get(10));
    }
}
