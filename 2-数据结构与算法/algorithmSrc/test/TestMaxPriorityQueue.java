package cn.ittj.algorithm.test;

import cn.ittj.algorithm.priority.MaxPriorityQueue;

public class TestMaxPriorityQueue {
    public static void main(String[] args) {
        MaxPriorityQueue<String> queue= new MaxPriorityQueue<>(10);

        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        while(!queue.isEmpty()){
            System.out.print(queue.delMax());
        }
    }
}
