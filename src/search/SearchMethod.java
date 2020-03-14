package search;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by asus on 2020/2/21.
 */
public class SearchMethod {
    static int maxSize=20;
    public static void main(String[] args) {
        System.out.println();
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        int index=fibSearch(arr,18);
        System.out.println("下标为"+(index+1));

    }

    //线性查找方法。过于简单，不详细解释
    public static void seqSearch() {

    }
    //二分查找的方法.只适用于有序表
    public static int binarySearch(int[] arr,int left,int right,int target)
    {
        if(left>right)
        {
            //表示找不到
            return -1;
        }
        int mid=(left+right)/2;
        int midValue=arr[mid];
        if(target>midValue)
        {
            return binarySearch(arr,mid+1,right,target);
        }else if(target<midValue)
        {
            return binarySearch(arr,left,mid-1,target);
        }else {
            return mid;
        }
    }

    //插值查找的算法，是二分查找的改进.只是将mid的定义改了一下。
    public static int insertValueSearch(int[] arr,int left,int right,int target)
    {
        if(left>right||target>arr[right]||target<arr[left])
        {
            return -1;
        }
        int mid=left+(right-left)*(target-arr[left])/(arr[right]-arr[left]);
        int midValue=arr[mid];
        if(target>midValue)//右递归
        {
            return insertValueSearch(arr,mid+1,right,target);
        }else if(target<midValue)//左递归
        {
            return insertValueSearch(arr,left,mid-1,target);
        }else {
            return mid;
        }
    }

    //斐波那契查找
    //首先得到一个斐波那契数列
    public static int[] fib()
    {
       int[] f=new int[maxSize];
        f[0]=1;f[1]=1;
        for(int i=2;i<maxSize;i++)
        {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    //主方法
    public static int fibSearch(int[] arr,int target)
    {
        int k=0;//k为fib数列下标值
        int low=0,high=arr.length-1;
        int mid=0;
        int f[]=fib();//得到斐波那契数列
        while (high>f[k]-1)//找到匹配arr.length长度的那个k值
        {
            k++;
        }
        //为了便于查找，需要创建一个新的数组,长度刚好为斐波那契数列里的一个数
        int[] temp= Arrays.copyOf(arr,f[k]);
        //为使temp依然有序，后面补齐arr[right]
        for(int i=high+1;i<f[k];i++)
        {
            temp[i]=arr[high];
        }
        //开始查找target索引值
        while(low<=high)
        {
            mid=low+f[k-1]-1;
            if(target<temp[mid])//左查找
            {
                high=mid-1;
                //因为查找都是将每个部分进行黄金分割。且f[k]=f[k-1]+f[k-2]
                //左查找，左边是f[k-1]的部分所以k--
                k--;
            }else if(target>temp[mid])
            {
                low=mid+1;
                //同样右边是f[k-2]，所以k-=2
                k-=2;
            }else {
                //找到了坐标值
                //这里的if是防止target刚好为最大值时，返回的索引为后面temp拼接部分的索引
                if(mid<=high)
                {
                    return mid;
                }else {
                    return high;
                }
            }

        }
        return -1;//这里才return就是没找到了
    }
}
