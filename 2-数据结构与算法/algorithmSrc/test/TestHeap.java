package cn.ittj.algorithm.test;

import cn.ittj.algorithm.Heap.Heap;

public class TestHeap {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(100);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("F");
        heap.insert("D");
        heap.insert("E");

        while(!heap.isEmpty()){
            System.out.println(heap.delMax());
        }
    }
}
