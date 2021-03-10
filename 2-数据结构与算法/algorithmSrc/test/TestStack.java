package cn.ittj.algorithm.test;

import cn.ittj.algorithm.linear.Stack;

public class TestStack {

    public static void main(String[] args) {
        Stack<String> s = new Stack();

        s.push("Milton");
        s.push("Jack");
        s.push("Rose");
        s.push("Alex");
        s.push("Mike");
        s.push("Ronald");
        System.out.println("=====栈内元素为=====");
        for (String i:s
             ) {
            System.out.println(i);
        }

        System.out.println("弹栈："+s.pop());
        System.out.println("弹栈："+s.pop());
        System.out.println("弹栈："+s.pop());
        System.out.println("=====栈内元素为=====");
        
    }
}
