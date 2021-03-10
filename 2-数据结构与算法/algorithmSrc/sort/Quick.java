package cn.ittj.algorithm.sort;

public class Quick {
    // 对数组内元素进行排序
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    // 对数组a从索引lo到hi之间元素进行排序
    private static void sort(Comparable[] a,int lo,int hi){
        // 安全性校验
        if(lo>=hi){
            return;
        }
        // 获得分界值，且对a进行分组
        int partition = partition(a,lo,hi);
        // 排序左子数组
        sort(a,lo,partition-1);
        // 排序右子数组
        sort(a,partition+1,hi);

    }

    // 对数组a中，从索引lo到hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a,int lo,int hi){
        /*逻辑清晰版本*/
        // 定义2个指针
        int p1 = lo;
        int p2 = hi;
        Comparable key = a[lo];
        // 循环
        while(p1<p2){
            // p2从右往左遍历，找比key小元素
            while(p1<p2){
                if(less(a[p2],key)){
                    break;
                }
                p2--;
            }
            // p1从左往右遍历，找比key大的元素
            while(p1<p2){
                if(less(key,a[p1])){
                    break;
                }
                p1++;
            }
            // p1<p2，交换元素
            if(p1<p2){
                exch(a,p1,p2);
            }
        }
        exch(a,p1,lo);
        return p1;

        /*一次循环方法*//*
        // 定义两个指针
        int p1 = lo;
        int p2 = hi;
        // 遍历
        // 左指针找比a[lo]大的元素，右指针找比a[lo]小的元素，成对交换
        while(p1<p2){
            if(less(a[p2],a[lo])){// p2找到小元素
                if(less(a[lo],a[p1])){// p1找到大元素
                    exch(a,p1,p2);
                    p1++;
                    p2--;
                }else{
                    p1++;
                }
            }else{
                p2--;
            }
        }
        exch(a,p1,lo);
        return p1;*/

        /* 需要两次循环
        // 遍历a，把比a[lo]小的元素放前面
        int partition = lo;
        for(int i=lo;i<=hi;i++){
            // 把比a[lo]小的元素放前面
            if(less(a[i],a[partition])){
                for(int j=i;j>partition;j--){
                    exch(a,j,j-1);
                }
                partition++;
            }
        }
        return partition;*/
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
