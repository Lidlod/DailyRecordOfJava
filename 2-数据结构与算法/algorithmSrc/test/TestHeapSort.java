package cn.ittj.algorithm.test;

import cn.ittj.algorithm.Heap.HeapSort;

import java.util.Arrays;

public class TestHeapSort {
    public static void main(String[] args) {
        //              String[] arr = {"S","O","R","T","E","X","A","M","P","L"};
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E","S"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
