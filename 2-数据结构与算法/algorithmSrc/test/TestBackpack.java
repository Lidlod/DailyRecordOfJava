package cn.ittj.algorithm.test;

import cn.ittj.algorithm.dp.backpack;

public class TestBackpack {
    public static void main(String[] args) {
        int[] w = {1,3,4};
        int[] v = {15,20,30};
//        int[] w = {1,4,3};
//        int[] v = {1500,3000,2000};
        backpack b01 = new backpack();
//        int maxValue = b01.backpack01(4,w,v);
//        int maxValue = b01.backpack01Scrolling(4,w,v);
        int maxValue = b01.comBackpack(4,w,v);
        System.out.println("maxValue:"+maxValue);

    }
}
