package cn.ittj.algorithm.sort;

public class Selection {
    //  Sort the elements in array a
    public static void sort(Comparable[] a) {
        // record minimum index
        int minIndex;
        for(int i=0;i<a.length-1;i++){
            // compare
            minIndex = i;
            for(int j=minIndex+1;j<a.length;j++){
                if(greater(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
//            exchange
            exch(a,i,minIndex);
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
