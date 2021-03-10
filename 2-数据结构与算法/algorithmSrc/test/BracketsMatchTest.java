package cn.ittj.algorithm.test;

import cn.ittj.algorithm.linear.Stack;

public class BracketsMatchTest {
    public static void main(String[] args) {
        Stack<String> ss = new Stack<>();
        String str = "(上海(长安)())";
        boolean match = ss.isMatch(str);
        System.out.println(str+"是否匹配:"+match);
    }
}
