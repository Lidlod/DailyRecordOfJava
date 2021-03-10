package cn.ittj.algorithm.Heap;

public class Heap <T extends Comparable<T>>{
    // 用来存储元素的数组
    private T[] items;
    // 记录堆中元素的个数
    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    // 判断堆中索引i处的元素是否小于索引j处的元素；
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    // 交换堆中索引i和索引j处的值；
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // 往堆中插入一个元素
    public void insert(T t){
        // 在数组最后添加元素t
        items[++N] = t;

        swim(N);
    }

    // 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        // h比上位小，则上位下移，不断重复；（不使用交换，可提升计算速度）
        while(k>1){
            if(items[k].compareTo(items[k/2])>0){
                exch(k,k/2);
                k = k/2;
            }else{
                break;
            }
        }
    }

    // 删除堆中最大元素，并返回这个最大元素
    public T delMax(){
        // 把最大元素和最后元素交换位置，删除最后元素
        if(N==0){
            return null;
        }
        T res = items[1];
        exch(1,N);
        items[N]=null;
        N--;
        // 根节点下沉
        sink(1);

        return res;
    }

    // 使用下沉算法，使索引k处的元素能在队中处于一个正确的位置
    private void sink(int k){
        // 和两个子结点比较，若比子结点小，和子结点中较大者交换位置
        // 左子结点要存在
        while(2*k<=N){
            // 右子结点不存在，直接比较和左子结点大小
            if(2*k+1>N){
                if(less(k,2*k)){
                    exch(k,2*k);
                    k = 2*k;
                }else{
                    break;
                }
            }else{// 右子结点存在
                int max;
                if(less(2*k,2*k+1)){
                    max = 2*k+1;
                }else{
                    max = 2*k;
                }
                if(less(k,max)){
                    exch(k,max);
                    k = max;
                }else{
                    break;
                }
            }
        }
    }

    // size
    public boolean isEmpty(){
        return this.N == 0;
    }
    public int size(){
        return this.N;
    }
}
