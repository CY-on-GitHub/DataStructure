package recursion;

import java.util.Map;

/**
 * Created by asus on 2020/2/17.
 */
public class Queue8 {

    //用一维数组解决八皇后问题.
    //皇后在棋盘上不能在同一行，同一列且不能在一条斜线上
    static int[] q=new int[8];
    static int count=0;
    static int judgeCount=0;

    public static void main(String[] args) {
        System.out.println();
        check(0);
        System.out.printf("一共有%d种解法",count);
        System.out.printf("总共进行了%d次冲突判断",judgeCount);

    }
    public static void check(int n)
    {
        if(n==8)//表示已经放完了
        {
           print();
            System.out.println();
            return;//直接结束

        }else{
            for(int i=0;i<8;i++)//因为外面有for循环，所以对每一个n,其他行的所有情况都会遍历一遍。check n深度递归，n增加到7后for才发挥作用，从最深处往回推找出所有符合的情况，保证从n=0的所以情况遍历完才进行第二个
            {
                //先判断第n行可以放哪个列数i
                q[n]=i;
                if(judge(n))//如果不冲突
                {
                   check(n+1);//这个递归可以将所有行数n的列数i确定好。
                }
            }
        }
    }

    public static boolean judge(int n)
    {
        judgeCount++;
        for(int i=0;i<n;i++)//这个是每在一行放一个棋子，先让它与之前放的作比较，判断是否符合条件
        {
            if(q[i]==q[n]||Math.abs(q[i]-q[n])== Math.abs(n-i))
            {
                //判断当前棋子是否在同一行、同一列或者一条斜线
                return false;
            }
        }
        return true;
    }

    public static void print() {//打印数组
        count++;
     for(int i:q)
     {
         System.out.print(i);
     }
    }
}
