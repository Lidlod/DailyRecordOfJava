package cn.ittj.algorithm.Heap;

public class HeapSort <T extends Comparable<T>>{

    // 判断heap堆中索引i处的元素i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }

    // 交换heap堆中的索引处的值
    private static void exch(Comparable[] heap, int i,int j){
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 对source中的数据从小到大排序
    public static void sort(Comparable[] source){
        // 初始化堆
        Comparable[] heap = new Comparable[source.length+1];
        createHeap(source,heap);

        for(int i=heap.length-1;i>1;i--){
            // 堆root和最后一个元素交换位置
            exch(heap,1,i);
            // root下沉
            sink(heap,1,i-1);
        }
        // 将heap中的元素拷贝到source中
        System.arraycopy(heap,1,source,0, heap.length-1);
    }

    // 根据原数组source，构造出堆heap
    private static void createHeap(Comparable[] source, Comparable[] heap){
        // 将数组拷贝入heap
        System.arraycopy(source,0,heap,1,source.length);
        // 从数组k/2处开始遍历
        int index = (heap.length)/2;
        while (index>0){
            // 对目标元素做下沉
            sink(heap,index,heap.length-1);
            // index--
            index--;
        }
    }

    // 在堆heap中，对target处的元素做下沉，范围是0-range。
    private static void sink(Comparable[]heap,int target,int range){
        // 存在左子结点
        while(2*target<=range){
            // 挑选子结点中，最大的元素
            // 存在右子节点
            int max;
            if(2*target+1<=range){
                if(less(heap,2*target,2*target+1)){
                    max = 2*target+1;
                }else{
                    max = 2*target;
                }
            }else{
                max = 2*target;
            }
            // 判断是否为最大值
            if(!less(heap,target,max)) {
                break;
            }
            // 交换最大结点
            exch(heap,target,max);
            // 继续
            target = max;
        }
    }
}
