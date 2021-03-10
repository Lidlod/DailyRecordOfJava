package cn.ittj.algorithm.priority;

public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;

    // 构造方法
    public MinPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    // 判断堆中索引i处的元素是否小于索引j处的元素；
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    // 交换堆中i索引和j索引处的值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // 删除队列中最大的元素，并返回这个最大元素
    public T delMin(){
        // 安全性检验
        if(this.N==0){
            return null;
        }
        T min;
        // 存储队列中最小元素
        min = items[1];
        // 交换堆首尾元素
        exch(1,this.N);
        items[N] = null;
        // N--；
        N--;
        // 头元素下沉sink
        sink(1);
        return min;
    }

    // 往队列中插入一个元素
    public void insert(T t){
        // 插在队尾
        // N++
        items[++N] = t;
        // 上浮
        swim(N);
    }

    // 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while(k>1){
            // 子节点大于父节点，上浮
            if(less(k/2,k)){
                break;
            }else{
                exch(k/2,k);
            }
            k = k/2;
        }
    }

    // 使用下沉算法，。。。
    private void sink(int k){
        // 判断左子节点是否存在
        while(2*k<=this.N){
            // 找到子节点中较小者
            int min;
            if(2*k+1<=N){
                if(less(2*k,2*k+1)){
                    min = 2*k;
                }else{
                    min = 2*k+1;
                }
            }else{
                min = 2*k;
            }
            // min大于父节点，break;
            if(less(k,min)){
                break;
            }
            // 交换节点，循环继续
            exch(k,min);
            k = min;
        }
    }

    // 获取队列中元素的个数
    public int size(){
        return this.N;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return this.N == 0;
    }
}
