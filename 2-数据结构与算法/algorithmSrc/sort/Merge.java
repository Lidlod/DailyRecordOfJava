 package cn.ittj.algorithm.sort;

public class Merge {
    // 完成归并需要的辅助数组
    private static Comparable[] assist;

//    // 构造方法
//    public Merge(){
//        assist = new Comparable[10];
//    }

    // 对数组内元素进行排序
    public static void sort(Comparable[] a){
        assist = new Comparable[a.length];
        sort(a,0,a.length-1);

    }

    // 对数组a从索引lo到hi之间元素进行排序
    private static void sort(Comparable[] a,int lo,int hi){
        // 安全性校验
        if(lo>=hi){
            return;
        }
        // 递归拆分序列，拆分到底后返回
        int mid = (lo+hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        // 合并数组
        merge(a,lo,mid,hi);
    }

    // 把两个子组合并为一个有序的大组
    private static void merge(Comparable[] a, int lo,int mid, int hi){
        // 2个指针指向lo和mid+1
        int p1 = lo;
        int p2 = mid+1;
        // 比较指针所指元素大小，小的放入assist数组，指针向后移位；
        // 指针结束条件判断
        for(int i=0;i<=hi-lo;i++){
            if(less(a[p1],a[p2])){
                assist[i] = a[p1];
                p1++;
                if(p1>mid){
                    System.arraycopy(a,p2,assist,i+1,hi-lo-i);
                    break;
                }
            }else if(p2<=hi){
                assist[i] = a[p2];
                p2++;
                if(p2>hi){
                    System.arraycopy(a,p1,assist,i+1,hi-lo-i);
                    break;
                }
            }
        }
        // 复制数组
        System.arraycopy(assist,0,a,lo,hi-lo+1);
    }

    // 判断v是否小于w
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    // 交换数组中，索引i和索引j处的值
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
