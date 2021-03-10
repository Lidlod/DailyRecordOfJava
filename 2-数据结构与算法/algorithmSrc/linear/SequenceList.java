package cn.ittj.algorithm.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    private T[] eles;// elements array
    private int N;// length;

    public SequenceList() {
    }

    // 创建容量位n的SequenceList对象
    public SequenceList(int n) {
        // 强制类型转换
        eles = (T[])new Object[n];
        //eles = new T[n];
        N = 0;
    }
    //空置线性表
    public void clear(){
        N=0;

    }
    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty(){
        return N==0;
    }
    // 获取线性表中元素的个数
    public int length(){
        return N;
    }
    //读取并返回线性表中第i个元素的值
    public T get(int i){
        return eles[i];
    }
    //在线性表的第i个元素之前插入一个值为t的数据元素
    public void insert(int i,T t){
        N++;
        for(int j=N-1;j>i;j--){
            eles[j]=eles[j-1];
        }
        eles[i]=t;
    }
    //在线性表中添加一个元素
    public void insert(T t){
        eles[N++]=t;
//        N++;
//        eles[N-1]=t;
    }
    // 删除并返回线性表中第i个数组元素
    public T remove(int i){
        T res = eles[i];
        for (int j=i;j<N-1;j++){// N-1, remove
            eles[j]=eles[j+1];
        }
        N--;
        return res;
    }
    //返回线性表中首次出现的指定数据元素的位序号，若不存在，则返回-1
    public int indexOf(T t){
        for(int i=0;i<N;i++){
            if (eles[i].equals(t)){// equals 默认比较基本数据类型的内容；比较引用对象的地址值；
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}
