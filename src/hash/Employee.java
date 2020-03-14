package hash;

/**
 * Created by asus on 2020/2/23.
 * 员工类，为了演示HashTable
 */
public class Employee {
   public int id;
    public String name;
    public Employee next=null;
    public Employee(int id,String name)
    {
        this.id=id;
        this.name=name;
    }
}
