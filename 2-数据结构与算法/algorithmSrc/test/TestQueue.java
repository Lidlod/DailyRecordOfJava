package cn.ittj.algorithm.test;

import cn.ittj.algorithm.linear.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();

        q.enqueue("Milton");
        q.enqueue("Leo");
        q.enqueue("Jack");
        q.enqueue("Rose");
        q.enqueue("Alex");
        System.out.println("====队列中的结点内容====");
        for (String i:q
             ) {
            System.out.println(i);
        }

        System.out.println("出队列："+q.dequeue());
        System.out.println("出队列："+q.dequeue());
        System.out.println("出队列："+q.dequeue());
        System.out.println("出队列："+q.dequeue());
        System.out.println("出队列："+q.dequeue());
        System.out.println("出队列："+q.dequeue());
        System.out.println("队列元素个数："+q.size());
        System.out.println("====链表中的结点内容====");
        for (String i:q
        ) {
            System.out.println(i);
        }

    }
}
