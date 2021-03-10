package cn.ittj.algorithm.test;

import cn.ittj.algorithm.linear.LinkList;

public class testLinkList {
    public static void main(String[] args) {
        LinkList<String> n1= new LinkList<String>();
        // 获取线性表中元素个数
        System.out.println("元素个数为："+n1.length());
        System.out.println("============");

        // 添加元素
        System.out.println("=======依次插入数据========");
        n1.insert("Milton");
        n1.insert("Jack");
        n1.insert("Rose");
        n1.insert("Leo");
        n1.insert("Franklin");
        n1.insert("Alex");
        System.out.println("在3中插入Stark");
        n1.insert(3,"Stark");
        // foreach输出
        for (String i: n1) {
            System.out.println(i);
        }

        // 倒序
        System.out.println("=====测试递归 单链表倒序=====");
        n1.reverse();
        for (String i: n1) {
            System.out.println(i);
        }

        // 获取中间结点，快慢指针
        System.out.println("=====获取中间结点=====");
        String midValue = n1.getMid();
        if (midValue==null){
            System.out.println("链表为空");
        }else{
            System.out.println("中间结点为："+midValue);
        }

        // 删除元素
        System.out.println("====删除元素"+n1.remove(2));
        for (String i: n1) {
            System.out.println(i);
        }

        //查找元素
        System.out.println("=====查找元素Leo======="+n1.indexOf("Leo"));

        //空置表格
        n1.clear();
        System.out.println("=====清空======");
        System.out.println("输出个数："+n1.length());
        for (String i: n1) {
            System.out.println(i);
        }
    }
}
