package other;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asus on 2020/2/25.
 * 这个类专门用来刷LeetCode上的题目
 */
public class LeetCode {
    public static void main(String[] args) {
        System.out.println();
    }


    //打印数组的简易方法
    public static void print(int[] q) {

        for(int a:q)
        {
            System.out.printf("%d ",a);
        }
        System.out.println();
    }
    //LeetCode第三题
    //任务：求出不含有重复字符的最长子串长度。采用的是滑动窗口法
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /*
    * 第四题：找出两个数组的中位数，要求时间复杂度为O(log n+m )
    * 1.暴力解法，取一个大数组重新排序，但时间复杂度不对
    * 2.二分法递归。这种时间复杂度一般想到的就是递归*/
    public static double find(int[] nums1,int[] nums2)
    {
        int[] num=new int[nums1.length+nums2.length];
        int left1=0,left2=0,index=0;
        boolean flag=false;
        while(index<=(num.length-1)&&flag==false)
        {

            if(nums1[left1]>=nums2[left2])
            {
                num[index++]=nums2[left2];
                left2++;
            }else {
                num[index++]=nums1[left1];
                left1++;
            }
            if(left1>nums1.length-1||left2>nums2.length-1)
            {
                flag=true;
            }
        }
        System.out.println("index="+index);
        //如果flag==true,则把另一个数组直接拷贝过去
        if(flag==true)
        {
            for(int i=left1;i<=nums1.length-1;i++)
            {
                num[index++]=nums1[i];
            }
            for(int j=left2;j<=nums2.length-1;j++)
            {
                num[index]=nums2[j];
                index++;
            }
        }
        print(num);

        if(num.length%2==0)//偶数长度
        {
            return (double)((num[num.length/2-1]+num[num.length/2])/2);
        }else {
            return (double)num[num.length/2];
        }
    }
}
