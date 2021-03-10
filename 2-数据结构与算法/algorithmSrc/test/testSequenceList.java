package cn.ittj.algorithm.test;

import cn.ittj.algorithm.linear.SequenceList;

import java.util.Arrays;

public class testSequenceList {
    public static void main(String[] args) {
        SequenceList<String> s1 = new SequenceList<String>(10);

        // 获取线性表中元素个数
        System.out.println(s1.length());

        // 添加元素
        s1.insert("Milton");
        s1.insert("Jack");
        s1.insert("Rose");
        s1.insert("Leo");
        System.out.println(s1.length());

        System.out.println("==============");
        for (String i:s1
             ) {
            System.out.println(i);
        }

        System.out.println("==============");
        s1.insert(3,"Ellie");
        System.out.println("length: "+s1.length());
        for (String i:s1
             ) {
            System.out.println(i);
        }

//        System.out.println(Arrays.toString(s1));

//        //空置表格
//        s1.clear();
        //删除元素
        System.out.println(s1.remove(2));

        System.out.println("The index: "+s1.indexOf("Leo"));
        System.out.println(s1.length());
    }
}
