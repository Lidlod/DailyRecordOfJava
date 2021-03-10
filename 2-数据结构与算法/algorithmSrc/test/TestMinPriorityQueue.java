package cn.ittj.algorithm.test;

import cn.ittj.algorithm.priority.MinPriorityQueue;

public class TestMinPriorityQueue {
    public static void main(String[] args) {
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);

        queue.insert("G");
        queue.insert("F");
        queue.insert("E");
        queue.insert("D");
        queue.insert("C");
        queue.insert("B");
        queue.insert("A");

        while(!queue.isEmpty()){
            System.out.print(queue.delMin());
        }
    }
}
