package cn.ittj.algorithm.sort;

public class Insertion {
    public static void sort(Comparable[] a) {
        for(int i = 1;i<a.length;i++){
            for (int j=i;j>0;j--){
                if(greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else{
                    break;
                }
            }
        }

    }

    /* Determine whether v is greater than w */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>=0;
    }

    /*
     * Swap the positions of i and j elements
     * */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
