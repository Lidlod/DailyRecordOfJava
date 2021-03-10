package cn.ittj.algorithm.test;

import cn.ittj.algorithm.sort.Bubble;

import java.util.Arrays;

public class testBubble {
    public static void main(String[] args) {
//        why to use Integer and Bubble?
//        1.Wrapper class can have field and method.
//        2.Static method can use Bubble.sort()
        Integer[] array1={3,5,6,343,434,7,3,6,4,5};
        Bubble.sort(array1);

//        why to use Arrays?
        System.out.println(Arrays.toString(array1));
    }
}
