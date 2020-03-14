package hash;

/**
 * Created by asus on 2020/2/24.
 */
public class EmpLinkedList {
    private Employee head;//设置一个头结点,存放第一个结点的指针

    public void add(Employee employee)
    {
        if(head==null)
        {
            head=employee;
            return;
        }
        Employee cur=head;
        while (true)//这个循环将cur指向到尾巴结点
        {
            if(cur.next==null)
            {
                break;
            }
            cur=cur.next;
        }
        cur.next=employee;

    }

    //展示所有结点信息
    public  void list(int no) {
        if(head==null)
        {
            System.out.println("第"+no+"条链表为空。");
            return;
        }
        System.out.println("打印第"+no+"条链表");
        Employee cur=head;//辅助指针
        while(true)
        {
            System.out.println("id="+cur.id+" name="+cur.name);
            if(cur.next==null){break;}
            cur=cur.next;
        }
    }

    //查找结点信息
    public Employee findEmpById(int id)
    {
        if(head==null)
        {
            //链表为空
            System.out.println("链表为空，无法查询");
            return null;
        }
        //辅助指针
        Employee cur=head;
        while (true)
        {
            if(cur.id==id)
            {
                //找到
                return cur;
            }
            if(cur.next==null)
            {
                //没有找到
                return null;
            }
            cur=cur.next;
        }
    }
}
