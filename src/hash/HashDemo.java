package hash;

/**
 * Created by asus on 2020/2/24.
 * 演示一个完整哈希表的构成：结点-结点的定义
 *                      链表-链表存放结点
 *                      哈希表-一个哈希表有size个链表。添加结点是要计算出该结点应该放进哪个链表里面
 */
public class HashDemo {
    public static void main(String[] args) {
        System.out.println();
        HashTab hashTab=new HashTab(7);
        hashTab.add(new Employee(4,"Evans"));
        hashTab.add(new Employee(3,"Alice"));
        hashTab.add(new Employee(7,"Tom"));
        hashTab.add(new Employee(14,"Steven"));
        hashTab.add(new Employee(45,"Harden"));
        hashTab.add(new Employee(9,"James"));
        hashTab.add(new Employee(1,"Eric"));
        hashTab.add(new Employee(33,"Upa"));
        hashTab.add(new Employee(16,"Chris"));
        hashTab.add(new Employee(20,"Stick"));
        hashTab.add(new Employee(6,"Job"));

        hashTab.list();

        hashTab.findEmpById(19);


    }

}
