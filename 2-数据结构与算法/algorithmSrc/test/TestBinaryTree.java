package cn.ittj.algorithm.test;

import cn.ittj.algorithm.linear.Queue;
import cn.ittj.algorithm.tree.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer,String>  t = new BinaryTree();
        System.out.println("找最小结点："+t.min());

        t.put(6,"ff");
        t.put(2,"bb");
        t.put(5,"ee");
        t.put(1,"aa");
        t.put(11,"aacc");
        t.put(3,"cc");
        t.put(4,"dd");
        System.out.println("元素个数为:"+t.size());

        System.out.println("找元素:"+t.get(3));

        System.out.println("删除元素5：");
        t.delete(5);
        System.out.println("元素个数为:"+t.size());
        System.out.println("找元素5:"+t.get(5));

        System.out.println("找最小结点："+t.min());
        System.out.println("找最大结点："+t.max());

        // 前序遍历
        System.out.println("前序遍历");
        Queue<Integer> keys1 = t.preErgodic();
        for(Integer i:keys1){
            String value = t.get(i);
            System.out.println(i+"----"+value);
        }

        // 中序遍历
        System.out.println("中序遍历");
        Queue<Integer> keys2 = t.midErgodic();
        for(Integer i:keys2){
            String value = t.get(i);
            System.out.println(i+"----"+value);
        }

        // 后续遍历
        System.out.println("后续遍历");
        Queue<Integer> keys3 = t.afterErgodic();
        for(Integer i:keys3){
            String value = t.get(i);
            System.out.println(i+"----"+value);
        }

        // 层序遍历
        System.out.println("层序遍历");
        Queue<Integer> keys4 = t.layerErgodic();
        for(Integer i:keys4){
            String value = t.get(i);
            System.out.println(i+"----"+value);
        }

        // 获取树的深度
        System.out.println("树的深度为："+t.maxDepth());
    }
}
