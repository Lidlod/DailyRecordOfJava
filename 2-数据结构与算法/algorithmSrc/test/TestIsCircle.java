package cn.ittj.algorithm.test;

import cn.ittj.algorithm.linear.LinkList;

public class TestIsCircle {
    public static void main(String[] args) {
        LinkList<String> l1 = new LinkList();

        // 添加元素
        System.out.println("=======依次插入数据========");
        l1.insert("Milton");
        l1.insert("Jack");
        l1.insert("Rose");
        l1.insert("Leo");
        l1.insert("Franklin");
        l1.insert("Alex",1);//形成环链表

//        // foreach输出
//        for (String i: l1) {
//            System.out.println(i);
//        }

        // 判断链表是否有环
        System.out.println("链表是否有环："+l1.isCircle());
        System.out.println("入口结点为："+l1.getEntrance());
    }
}
