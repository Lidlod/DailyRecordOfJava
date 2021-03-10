package cn.ittj.algorithm.test;
//test method Comparable getMax(Comparable c1, Comparable c2)

import cn.ittj.algorithm.sort.Student;

public class testComparable {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setUsername("Milton");
        s1.setAge(18);

        Student s2 = new Student();
        s2.setUsername("Leo");
        s2.setAge(33);

//        System.out.println(s2);
        System.out.println(getMax(s1,s2));
    }

    public static Comparable getMax(Comparable c1, Comparable c2){
        int result = c1.compareTo(c2);
        if (result>=0) {
            return c1;
        }else{
            return c2;
        }
    }

}
