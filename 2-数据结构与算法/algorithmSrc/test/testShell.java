package cn.ittj.algorithm.test;

import cn.ittj.algorithm.sort.Shell;

import java.util.Arrays;

public class testShell {
    public static void main(String[] args) {
        Integer[] array1={3,5,1,46,55,43,4,5};
        Shell.sort(array1);

        System.out.println(Arrays.toString(array1));
    }
}
