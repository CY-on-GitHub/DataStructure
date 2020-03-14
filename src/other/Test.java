package other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by asus on 2020/2/22.
 * 这个类只用于做题时测试用
 */
public class Test {

    static ArrayList a=new ArrayList();

    public static void main(String[] args) {
       int[] n1=new int[]{1,3,5,7,9,11,15};
       int[] n2=new int[]{2};
       int[][] array=new int[][]{{1,3,5,7,9},{3,5,7,9,11},{5,7,9,11,13},{7,9,11,13,15}};
      /* System.out.println(array.length+" "+array[0].length);
       System.out.println(Find(1,array));

       StringBuffer str;
       str = new StringBuffer("We are happy");
       System.out.println(replaceSpace(str));*/

       /* other.ListNode listNode=new other.ListNode(0);
        listNode.next=new other.ListNode(1);
        listNode.next.next=new other.ListNode(2);*/
        ListNode listNode=null;

        printArrayList(printListFromTailToHead(listNode));

        ArrayList<Integer> list=new ArrayList<Integer>();
       
        

    }

    //打印数组的简易方法
    public static void print(int[] q) {

        for(int a:q)
        {
            System.out.printf("%d ",a);
        }
        System.out.println();
    }

    public static void printF(float[] q) {

        for(float a:q)
        {
            System.out.printf("%f ",a);
        }
        System.out.println();
    }

  public static int binarySort(int[] a,int l, int r, int target)
  {
      int mid=(l+r)/2;
      int left=l,right=r;

      if(left>right){
          System.out.println("没有找到target");
          return -1;}
      if(a[mid]<target)
      {
          return binarySort(a,mid+1,right,target);
      }else if(a[mid]>target)
      {
          return binarySort(a,left,mid-1,target);

      }else {
          return mid;
      }

  }


    public  static float[] ballFall(int times)
    {
        float ans1=0,ans2=100;//分别记录总路径和第n次反弹的高度
        int i=1;
        while((i++)<=times)
        {
            ans1=ans1+ans2;
            ans2=bF(ans2);
        }
        float[] ans=new float[]{ans1*2-100,ans2};
        return ans;
    }

    public  static float bF(float hight)
    {
        return hight/2;
    }

    /**
     * 这个是用来获取两个日期的差值的
     *
     * @return 差值
     */
    public static Long getSubTime(String date3,String date4) {
        Date date1 = null, date2 = null;
        //使用SimpleDateFormat类格式化日期
        SimpleDateFormat rule = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date1 = rule.parse(date3);
            date2 = rule.parse(date4);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Long time1 = date1.getTime();
        Long time2 = date2.getTime();
        Long time3 = time1 > time2 ? time1 - time2 : time2 - time1;
        return time3/(86400000);
    }
    /*
    * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    * 每一列都按照从上到下递增的顺序排序。
    * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    * */
    public static boolean Find(int target, int [][] array) {
        int row = array.length;
        int line = array[0].length;
        //选择左下角为开始目标
        int i = row - 1, j = 0;
        while (i >= 0 && j < line && array[i][j] != target) {
            if (array[i][j] > target) {
                //往上找
                i--;
            } else {
                //往右找
                j++;
            }
        }
        if (!(i >= 0 && j < line) ){
               return false;
        }else {
            return true;
        }
    }
    /*
    * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
    public static String replaceSpace(StringBuffer str) {

        int i=0;
        while(i<str.length())
        {
            if(str.charAt(i)==' ')
            {
                str.replace(i,i+1,"%20");
            }
            i++;
        }

      return str.toString();
    }
    /*输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    * 题解：应该用栈比较好，递归的方法反而麻烦了*/
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arrayList=new ArrayList();

        return arrayList;
    }
    public static ListNode hasNext(ListNode listNode)
    {
            return listNode;
    }
    public static void printArrayList(ArrayList arrayList)
    {
        for (int i=0;i<arrayList.size();i++)
        {
            System.out.println(arrayList.get(i));
        }
    }

}
