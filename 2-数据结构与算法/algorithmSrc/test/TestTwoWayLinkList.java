package cn.ittj.algorithm.test;

import cn.ittj.algorithm.linear.TwoWayLinkList;

public class TestTwoWayLinkList {
    public static void main(String[] args) {
        TwoWayLinkList<String> n1= new TwoWayLinkList<String>();
        // 获取线性表中元素个数
        System.out.println("元素个数为："+n1.length());
        System.out.println("============");

        // 添加元素
        System.out.println("=======依次插入数据========");
        n1.insert("Milton");
        n1.insert("Jack");
        n1.insert("Rose");
        n1.insert("Leo");
        System.out.println("在3中插入Stark");
        n1.insert(3,"Stark");
        for (String i: n1) {
            System.out.println(i);
        }

        //删除元素
        System.out.println("====删除元素"+n1.remove(4));
        for (String i: n1) {
            System.out.println(i);
        }

        //查找元素
        System.out.println("=====查找元素Leo======="+n1.indexOf("Leo"));

        // 获取第一个元素和最后一个元素
        System.out.println("获取第一个元素:"+n1.getFirst());
        System.out.println("获取最后一个元素:"+n1.getLast());

        //空置表格
        n1.clear();
        System.out.println("=====清空======");
        System.out.println("输出个数："+n1.length());
        for (String i: n1) {
            System.out.println(i);
        }
    }
}
