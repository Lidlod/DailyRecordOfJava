package cn.ittj.algorithm.linear;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T>{
    private Node first;
    private Node last;
    private int N;

    private class Node<T>{
        T item;
        Node next;
        Node pre;

        public Node(T item, Node next, Node pre) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }

    // 创建TwoWayLinkList对象；
    public TwoWayLinkList() {
        this.first=new Node(null,null,null);
        this.last=null;// 初始化尾节点中并没有数据；
        this.N=0;
    }

    // 空置线性表；
    public void clear(){
        this.first.next = null;
        this.last = null;
        this.N = 0;
    }

    // 判断线性表是否为空，是返回true，否返回false；
    public boolean isEmpty(){
        return this.N == 0;
    }

    // 获取线性表元素个数
    public int length(){
        return N;
    }

    // 读取并返回线性表中第i个元素
    public T get(int i){
        Node nTemp = first.next;
        for(int j=0;j<i;j++){
            nTemp = nTemp.next;
        }
        return (T) nTemp.item; // 为什么需要强制类型转换??
    }

    // 往线性表中添加一个元素；
    public void insert(T t){
        Node n = first;
        while(n.next != null){
            n = n.next;
        }
        Node newNode = new Node(t,null, n);
        n.next = newNode;
        this.last = newNode;
        N++;
    }

    // 在线性表第i个元素之前插入一个值为t的数据元素
    public void insert(int i,T t){
        Node pre = first;
        for (int j =0;j < i;j++){
            pre = pre.next;
        }
        Node curr = pre.next;
        Node newNode = new Node(t,curr,pre);
        pre.next = newNode;
        curr.pre = newNode;
        N++;
    }

    // 删除并返回线性表中第i个数据元素
    public T remove(int i){
        Node pre = first;
        for (int j =0;j < i;j++){
            pre = pre.next;
        }
        Node curr = pre.next;
        Node currNext = curr.next;
        pre.next = currNext;
//        currNext.pre = pre;
        if(currNext != null) {// 考虑删除最后一个元素的情况；
            currNext.pre = pre;
        }else{
            this.last = pre;
        }
        N--;
        return (T) curr.item; // 强制类型转换？
    }

    // 返回线性表中首次出现的指定数据元素的位序号，若不存在，则返回-1；
    public int indexOf(T t){
        Node n = first.next;
        for (int j =0;n!=null;j++){
            if (n.item.equals(t)){
                return j;
            }
            n = n.next;
        }
        return -1;
    }

    // 获取第一个元素
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return (T) first.next.item;
    }

    // 获取最后一个元素
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return (T) last.item;
    }

    // Iterator 接口重写，为使用增强for
    @Override
    public Iterator<T> iterator() {// 迭代器有泛型
        return new TWIterator();
    }
    private class TWIterator<T> implements Iterator {
        private Node n;

        public TWIterator() {
            this.n = first;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n= n.next;
            return n.item;
        }
    }

}
