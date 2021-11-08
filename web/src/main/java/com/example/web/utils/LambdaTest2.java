package com.example.web.utils;

/**
 * 1.lambda 表达式的基础语法 Java8中引入了一个新的操作符 -> 称为箭头操作符或者lambda操作符
 * 左侧 lambda 表达式的参数列表
 * 右侧 lambda 表达式中所需执行的功能 即lambda 体
 * 语法格式1
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }

        };
        r.run();
        System.out.println("---------------");
        Runnable r1 = ()-> {System.out.println("hello");};
        r.run();
    }
}
