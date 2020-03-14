package other;

/**
 * Created by asus on 2020/3/6.
 * 测试volatile。
 */
public class VolatileExample {
    private int a = 0;
    private volatile boolean flag = false;
    public void writer(){
        a = 1;
        System.out.println("测试volatile数据1--"+a);
        flag = true;//但是注意这里的flag是当前线程独立内存里的，会变成true
        System.out.println("测试volatile数据2--"+flag);
    }
    public void reader(){
        System.out.println("测试volatile数据3--"+flag);
        if(flag){
            int i = a;
            System.out.println("测试volatile数据4--"+i);
        }
    }
/*
* 简单来说，volatile让变量每次在使用的时候，都从主存中取。而不是从各个线程的“工作内存”。
* 检查上面程序的输出，可以发现反正无论如何，都会输出：测试volatile数据3--false，都不会输出：测试volatile数据4的结果，
* 这是因为reader方法，每次读取的都是主存中的值，不会因writer方法改变*/
}
