package cn.ittj.algorithm.linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node head;
    private int N;

    private  class Node{
        public T item;
        public Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    // 判断当前栈中元素是否为0；
    public boolean isEmpty(){
        return N == 0;
    }

    // 获取栈中元素的个数
    public int size(){
        return N;
    }

    // 把t元素压入栈
    public void push(T t){
        Node temp = new Node(t,head.next);
        head.next = temp;
        N++;
    }

    // 弹出栈顶元素
    public T pop(){
        if(N==0){
            return null;
        }
        T temp = head.next.item;
        head.next = head.next.next;
        N--;
        return temp;

    }

    // 判断str中的括号是否匹配
    public boolean isMatch(String str){
        // 创建一个栈；
        Stack<String> leftBrackets = new Stack<>();

        // 遍历字符串
        // 若为（，压栈；若为），弹栈
        for(int i=0;i<str.length();i++){
            char temp = str.charAt(i);
            if(temp == '('){
                leftBrackets.push(String.valueOf(temp));
            }else if(temp == ')'){
                if(leftBrackets.pop() == null){
                    return false;
                }
            }
        }
        // 遍历完后，栈中应该无元素
        if(leftBrackets.size()>0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator<T> implements Iterator{
        private Node s;

        public SIterator() {
            this.s = head;
        }

        @Override
        public boolean hasNext() {
            return s.next!=null;
        }

        @Override
        public Object next() {
            s = s.next;
            return s.item;
        }
    }
}
