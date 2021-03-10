package cn.ittj.algorithm.sort;

public class Bubble{
//    Comparable para? Downcast.
    public static void sort(Comparable[] a) {
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    /* if v is greater than w */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>=0;
    }

    /*
    * i and j exchange
    * */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
