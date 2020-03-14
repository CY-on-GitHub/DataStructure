package other;

/**
 * Created by asus on 2020/2/27.
 */
public class ListNode {
   int num;
    ListNode next=null;

    public ListNode(int num){
        this.num=num;
    }

    @Override
    public String toString() {
        return "other.ListNode{" +
                "num=" + num +
                '}';
    }
}
