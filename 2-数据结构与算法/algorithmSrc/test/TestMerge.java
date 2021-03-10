package cn.ittj.algorithm.test;

import cn.ittj.algorithm.sort.Merge;

import java.util.Arrays;

public class TestMerge {
    public static void main(String[] args) {
        Integer [] arr = {4,1,2,4,3,2,54,2,3};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
