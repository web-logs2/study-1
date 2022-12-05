package com.example.mybatisdemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenyile
 * @date 2022/11/19  15:51
 * @description:
 */
public class TestRead {
    public static void main(String[] args) throws IOException {
        //List<String> list = FileUtils.readLines
        //        (new File("C:\\Users\\chenyile\\Desktop\\值班任务\\核酸结果.txt"));
        //
        //Map<String, String> result = new HashMap<>();
        //for (String s : list) {
        //    String[] split = s.split("\t", -1);
        //    if (!result.containsKey(split[0])) {
        //        if (split[2].contains("阴性")) {
        //            result.put(split[0], split[1]);
        //        }
        //    }
        //}
        //result.forEach((k,v)-> System.out.println(k+"\t"+v));
        Map<String, String> map = new HashMap<>();
        List<String> list = FileUtils.readLines(new File("C:\\Users\\chenyile\\Desktop\\result3.txt"));
        for (String s : list) {
            String[] split = s.split("\t", -1);
            map.put(split[0], split[1]);
        }
        List<String> list1 = FileUtils.readLines(new File("C:\\Users\\chenyile\\Desktop\\result4.txt"));
        for (String s : list1) {
            String[] split = s.split("\t");
            System.out.println(split[0]+"\t"+map.getOrDefault(split[0],"---"));
        }
    }
}
