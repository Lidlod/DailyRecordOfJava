package cn.ittj.algorithm.sort;

public class Shell {

    public static void sort(Comparable[] a) {
        // set step h
        int h=1;
        while(h<a.length/2){
            h=2*h+1;
        }

        while(h>0){
//            // for*3, not best.
//            // get first element
//            for (int i=0;i<h;i++){
//                // Insertion sort
//                for(int j=i+h;j<a.length;j=j+h){
//                    for(int k=j;k>0;k-=h){
//                        if(greater(a[k-h],a[k])){
//                            exch(a,k-h,k);
//                        }else{
//                            break;
//                        }
//                    }
//                }
//            }
//            h=h/2;

            // Insertion sort
            for(int i=h;i<a.length;i++){
                for(int j=i;j>=h;j-=h){
                    if(greater(a[j-h],a[j])){
                        exch(a,j-h,j);
                    }else{
                        break;
                    }
                }
            }
            h=h/2;
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
