package com.example.leetcode.leetcode;

class LeetCode1768 {
    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        int index = 0;
        StringBuilder res = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i == word1.length()) {
                return res.append(word2.substring(j)).toString();
            }
            if (j == word2.length()) {
                return res.append(word1.substring(i)).toString();
            }
            if (index % 2 == 0) {
                res.append(word1.charAt(i));
                i++;
            } else {
                res.append(word2.charAt(j));
                j++;
            }
            index++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
    }
}