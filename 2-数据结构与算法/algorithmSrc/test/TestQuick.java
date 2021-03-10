package cn.ittj.algorithm.test;

import cn.ittj.algorithm.sort.Quick;

import java.util.Arrays;

public class TestQuick {
    public static void main(String[] args) {
        Integer [] arr = {4,1,2,4,3,2,54,2,3};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
