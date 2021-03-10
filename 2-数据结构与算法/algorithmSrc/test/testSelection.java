package cn.ittj.algorithm.test;

import cn.ittj.algorithm.sort.Selection;

import java.util.Arrays;

public class testSelection {
    public static void main(String[] args) {
        Integer[] array1={3,5,6,4,5};
        Selection.sort(array1);

        System.out.println(Arrays.toString(array1));
    }
}
