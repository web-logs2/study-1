package com.example.methodArea;

/**
 * @author chenyile
 * @date 2022/9/20  22:19
 * @description: //java8 s.intern():将s对象尝试放入串池中，如果有则不会放入，没有就放入串池，并把串池的对象返回赋值给
 */
public class StrTest {
    public static void main(String[] args) {

        String s = new String("a") + new String("b");
        //s.intern():将s对象尝试放入串池中，如果有则不会放入，没有就放入串池，并把串池的对象返回赋值给s
        System.out.println(s == "ab");
        String intern = s.intern();
        System.out.println(intern == "ab");
    }
}
