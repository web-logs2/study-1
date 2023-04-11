package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test {

    List<String> result = new ArrayList<>();


    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb);
        return result;
    }

    public void dfs(int left, int right, StringBuilder sb) {
        if (right == 0 && left == 0) {
            result.add(sb.toString());
            return;
        }
        // 保证不能超过括号对的数量，同时右括号的使用次数不能超过左括号的次数
        if (left < 0 || right < 0 || right < left) {
            return;
        }
        dfs(left - 1, right, sb.append("("));
        dfs(left, right - 1, sb.append(")"));
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.generateParenthesis(3);
        System.out.println(test.result);
    }
}
