package cn.ittj.algorithm.linear;

import java.lang.annotation.Inherited;
import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{
    private Node head;
    private int N;

    // 初始化头节点
    public LinkList() {
        this.head = new Node(null,null);
        this.N = 0;
    }

    // 节点内部类；
    private class Node<T>{
        T item;
        Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    // 空置线性表；
    public void clear(){
        head.next = null;
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
        Node nTemp = head.next;
        for(int j=0;j<i;j++){
            nTemp = nTemp.next;
        }
        return (T) nTemp.item; // 为什么需要强制类型转换??视屏58，中间值问题7:40；
    }

    // 往线性表中添加一个元素；
    public void insert(T t){
        Node n = head;
        while(n.next != null){
            n = n.next;
        }
        Node ns = new Node(t,null);
        n.next = ns;
        N++;
    }

    // 往线性表中添加一个元素，并将该元素的为节点指向链表index的位置
    public void insert(T t, int index){
        Node n = head.next;
        Node p = null;// 用于形成环
        for(int i=0;n.next!=null;i++){
            if(index == i){
                p = n;
            }
            n = n.next;
        }
        Node ns = new Node(t,p);
        n.next = ns;
        N++;
    }

    // 在线性表第i个元素之前插入一个值未t的数据元素
    public void insert(int i,T t){
        Node pre = head;
        for (int j =0;j < i;j++){
            pre = pre.next;
        }
        Node newNode = new Node(t,pre.next);
        pre.next = newNode;
        N++;
    }

    // 删除并返回线性表中第i个数据元素
    public T remove(int i){
        Node pre = head;
        for (int j =0;j < i;j++){
            pre = pre.next;
        }
        Node curr = pre.next;
        pre.next = curr.next;
        N--;
        return (T) curr.item; // 强制类型转换？
    }

    // 返回线性表中首次出现的指定数据元素的位序号，若不存在，则返回-1；
    public int indexOf(T t){
        Node n = head.next;
        for (int j =0;n!=null;j++){
            if (n.item == t){
                return j;
            }
            n = n.next;
        }
        return -1;
    }

    // Iterator 接口重写，为使用增强for
    @Override
    public Iterator<T> iterator() {// 迭代器有泛型
        return new Literator();
    }
    private class Literator<T> implements Iterator {
        private Node n;

        public Literator() {
            this.n = head;
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

    // 对整个链表反转
    public void reverse(){
        reverse(head.next);
    }

    // 反转链表中的某个结点curr，并把反转后的curr结点返回
    public Node reverse(Node curr){
        // 若为最后一个结点
        if(curr.next==null){
            this.head.next = curr;
            return curr;
        }

        // 递归的反转当前节点curr的下一个结点；返回值就是链表反转后，当前结点的上一个结点；
        // @@ 先搜索到最后一个结点，再依次返回结点重指指针；
        Node pre = reverse(curr.next);
        pre.next = curr;// 返回的结点的下一个结点变为当前结点curr；
        curr.next = null;// 把当前结点的下一个结点变为null；
        return curr;
    }

    // 快慢指针获得中间节点
    public T getMid(){
        // 判断数组是否为空
        if(head.next == null){
            return null;
        }

        // 定义快慢指针
        Node<T> fast = head.next;
        Node<T> slow = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    // 判断链表是否有环
    public boolean isCircle(){
        // 判断链表是否为空
        if (isEmpty()){
            return false;
        }

        // 定义快慢指针
        Node<T> fast = head.next;
        Node<T> slow = head.next;
        boolean flag = false;

        // 快指针和慢指针相遇，则说明有环
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                flag = true;
                break;
            }
        }
        return flag;
    }

    // 查找有环链表的入口结点
    public T getEntrance(){
        // 判断链表是否为空
        if (isEmpty()){
            return null;
        }

        // 定义快慢指针
        Node<T> fast = head.next;
        Node<T> slow = head.next;
        Node<T> temp = head.next;
        boolean flag = false;

        // 快指针和慢指针相遇，则说明有环
        while(fast!=null && fast.next!=null){
            if(!flag) {
                fast = fast.next.next;
            }else{
                temp = temp.next;
            }
            slow = slow.next;

            if(fast == slow && !flag){
                flag = true;
            }else if(temp == slow){
                break;
            }
        }
        return temp.item;

    }
}
