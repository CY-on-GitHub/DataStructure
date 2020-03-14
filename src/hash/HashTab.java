package hash;

import java.util.HashSet;

/**
 * Created by asus on 2020/2/24.
 * 哈希表
 */
public class HashTab {

    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTab(int size)
    {
        this.size=size;
        empLinkedLists=new EmpLinkedList[size];
        //这里尤其注意！！！
        //每一条链表都需要初始化
        for(int i=0;i<size;i++)
        {
            empLinkedLists[i]=new EmpLinkedList();
        }
    }

    public void add(Employee employee)
    {
        //根据员工的id，得到该员工应当添加到
        empLinkedLists[hashFunction(employee.id)].add(employee);
    }

    //遍历哈希表
    public void list()
    {
       for(int i=0;i<size;i++)
       {
           empLinkedLists[i].list(i);
       }
    }
    //定义的哈希函数
    public int hashFunction(int id)
    {
        return id%size;
    }

    //根据id查找结点
    public void findEmpById(int id)
    {
        Employee employee=empLinkedLists[hashFunction(id)].findEmpById(id);
        if(employee==null)
        {
            System.out.println("没有找到id为:"+id+" 的雇员");
        }else {
            System.out.println("找到了，此id="+id+" 的雇员名字="+employee.name);
        }
    }
}

