package com.example.leetcode.leetcode;

/**
 * @author chenyile
 * @date 2023/2/19  12:10
 * @description:
 */
public class Offer58 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuilder.append(split[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    //hello  world
    public String reverseWords2(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s, i + 1, j + 1).append(" ");
            //跳过单词间的空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {

    }
}
