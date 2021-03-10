package cn.ittj.algorithm.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;

    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    // 返回队列中元素的个数
    public int size(){
        return N;
    }

    // 向队列中插入元素t；向尾部插入元素
    public void enqueue(T t){
        Node temp = new Node(t,null);
        if(isEmpty()){
            head.next = temp;
        }else{
            last.next = temp;

        }
        last = temp;
        N++;

    }

    // 从队列中拿出一个元素
    public T dequeue(){
        // 拿出head后的结点
        if(isEmpty()){
            return null;
        }
        Node nextNode = head.next;
        T res = nextNode.item;
        if(nextNode.next == null){
            last = null;
        }
        head.next = nextNode.next;

        N--;
        return res;
    }

    @Override
    public Iterator iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{
        Node n;
        public QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
