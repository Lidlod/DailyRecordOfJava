package cn.ittj.algorithm.test;

import cn.ittj.algorithm.sort.Insertion;

import java.util.Arrays;

public class testInsertion {
    public static void main(String[] args) {
        Integer[] array1={3,5,46,55,43,4,5};
        Insertion.sort(array1);

        System.out.println(Arrays.toString(array1));
    }

}
