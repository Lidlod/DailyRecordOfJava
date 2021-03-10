package cn.ittj.algorithm.sort;
// Set Class Student, para: age and username. Comparable interference
public class Student implements Comparable<Student>{
    private String username;
    private int age;

    public Student() {
    }

    public Student(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();
    }
}
