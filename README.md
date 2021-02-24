# DailyRecordOfJava
## Java基础
### 建议
尽早开始，早开始主要是因为量大；

### 学习路线
>学习过程中，带着目标学习，注意关键词；

Java集合类：集合框架；hashmap(线程不安全)、红黑树、hashtable、CAS
ArrayList and LinkedList

多线程（操作系统）：synchronized 、线程池、锁 死锁、CAS
MySQL：查询语句、索引、B+树

JVM/GC：垃圾回收、OOM、判断死亡方法、

多线程与高并发（JUC）：synchronized 性能为什么提高了
计算机网络通信：http、TCP/IP


异常、try- catch、单例模式、
redis
JVM 内存划分， 堆内存分代 堆划分、垃圾回收
Java的集合

### 多线程

多线程（操作系统）：synchronized 、线程池、锁 死锁、CAS



- 程序、线程和进程

程序：为完成特定任务、用某种语言编写的一组指令的集合。即指一 段静态的代码，静态对象。

线程：是程序的一次执行过程，或是正在运行的一个程序。是一个动态 的过程：有生命周期；

进程：进程可进一步细化为线程，是一个程序内部的一条执行路径。

比如电脑中的IDEA，没跑起来是程序，跑起来后运行的程序是一段进程，进程种有多个线程；

一个进程中的多个线程共享相同的内存单元/内存地址空间，它们从同一堆中分配对象，可以访问相同的变量和对象。这就使得线程间通信更简便、高效。但多个线程操作共享的系统资源可能就会带来**安全的隐患**。

一个Java应用程序java.exe，其实至少有三个线程：main()主线程，gc() 垃圾回收线程，异常处理线程。当然如果发生异常，会影响主线程。



多线程优点，给其他任务执行提供机会。。。；

并行与并发：

并行：多个任务被同时执行；多个CPU同时执行多个任务；

并发：多个任务能被处理，但不一定是同时；单个CPU同时执行多个任务；

- 线程的创建

JDK1.5之前创建新执行线程有两种方法：

1. 继承Thread类的方式  
2. 实现Runnable接口的方式

JDK5.0



方式一：继承Thread类

1) 定义子类继承Thread类。 

2) 子类中重写Thread类中的run方法。 

3) 创建Thread子类对象，即创建了线程对象。 

4) 调用线程对象start方法：启动线程，调用run方法。

```java
//1. 创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2. 重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //4.通过此对象调用start():①启动当前线程 ② 调用当前线程的run()。不能直接调用run()
        t1.start();
    }
}

```

Tips1：创建多个仅用一次的线程，可用匿名子类的方式；

```java
// 创建匿名子类的方式
        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
```

Tips2：多个线程对象操作同一个变量，需要声明为静态；（仍存在线程安全问题）

```java
    private static int ticket = 100;
```



方式二：实现Runnable接口

1) 定义子类，实现Runnable接口。 2) 子类中重写Runnable接口中的run方法。 3) 通过Thread类含参构造器创建线程对象。 4) 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。 5) 调用Thread类的start方法：开启线程，调用Runnable子类接口的run方法。

```java
//1) 定义子类，实现Runnable接口。
class MyThread implements Runnable{
    //2) 子类中重写Runnable接口中的run方法。
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        //3) 通过Thread类含参构造器创建线程对象。
        MyThread t = new MyThread();
        //4) 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
        Thread thread = new Thread(t);
        //5) 调用Thread类的start方法：开启线程，调用Runnable子类接口的run方法。
        thread.start();
    }
}
```

源码分析：thread调用对象t，然后调用t中的run()方法；（调用Runnable类型的target的run方法）

开发中：优先选择：实现Runnable接口的方式

 区别：继承Thread：线程代码存放Thread子类run方法中。  实现Runnable：线程代码存在接口的子类的run方法。

 实现方式的好处：避免了单继承的局限性  多个线程可以共享同一个接口实现类的对象，非常适合多个相同线 程来处理同一份资源。



新增方式一：实现Callable接口

与使用Runnable相比， Callable功能更强大些 

1. 相比run()方法，可以有返回值 
2. 方法可以抛出异常 
3. 支持泛型的返回值 
4. 需要借助FutureTask类，比如获取返回结果

新增方式二：使用线程池
