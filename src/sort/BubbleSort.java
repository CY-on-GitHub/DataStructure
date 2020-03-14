package sort;

/**
 * Created by asus on 2020/2/17.
 * //演示各种排序算法
 */
public class BubbleSort {
    public static void main(String[] args) {
        int max=80000;
        int[] q=new int[max];//测试时间用数组
        int [] p={4, 6, 8, 5, 9,2,14,36,22,0,-5,14};//测试算法执行思路用数组
        for(int a=0;a<max;a++)
        {
            q[a]=(int)(Math.random()*1000);
        }

//        //测试代码运行时间
//        System.out.println("冒泡排序演示");
//        long start=System.currentTimeMillis();
//        bubbleSort(q);//--------------------------20000ms左右
//        long end=System.currentTimeMillis();
//        System.out.println("程序运行时间为："+(end-start)+"ms");

//        System.out.println("选择排序演示");
//        long start1=System.currentTimeMillis();
//        selectSort(q);//----------------------8000ms左右
//        long end1=System.currentTimeMillis();
//        System.out.println("程序运行时间为："+(end1-start1)+"ms");

//        System.out.println("插入排序演示");
//        long start1=System.currentTimeMillis();
//        insertSort(q);//---------------------------1000ms左右
//        long end1=System.currentTimeMillis();
//        System.out.println("程序运行时间为："+(end1-start1)+"ms");

//        System.out.println("交换型希尔排序演示");
//        long start3=System.currentTimeMillis();
//        shell_1_Sort(q);      //---------------------------10000ms左右
//        long end3=System.currentTimeMillis();
//        System.out.println("程序运行时间为："+(end3-start3)+"ms");


//        System.out.println("移动型希尔排序演示");
//        long start3=System.currentTimeMillis();
//        shell_2_Sort(q);      //---------------------------20ms左右!!!!!
//        long end3=System.currentTimeMillis();
//        System.out.println("程序运行时间为："+(end3-start3)+"ms");

       /*System.out.println("快速排序1演示");
        long start4=System.currentTimeMillis();
        quickSort(q,0,q.length-1);     //---------------------------60ms左右!!!!!
        long end4=System.currentTimeMillis();
        System.out.println("程序运行时间为："+(end4-start4)+"ms");*/

        /*System.out.println("快速排序2演示");
        long start4=System.currentTimeMillis();
        quickSort2(q,0,q.length-1);     //---------------------------60ms左右!!!!!
        long end4=System.currentTimeMillis();
        System.out.println("程序运行时间为："+(end4-start4)+"ms");*/

       /* int[] temp=new int[q .length];
        System.out.println("归并排序演示");
        long start4=System.currentTimeMillis();
        mergeSort(q,0,q.length-1,temp);     //---------------------------22ms左右!!!!!
        long end4=System.currentTimeMillis();
        System.out.println("程序运行时间为："+(end4-start4)+"ms");*/


       /* System.out.println("基数排序演示");
        long start4=System.currentTimeMillis();
        radixSort(q);                       //---------------------------30ms左右!!!!!
        long end4=System.currentTimeMillis();
        System.out.println("程序运行时间为："+(end4-start4)+"ms");*/

        System.out.println("堆排序演示");
        long start4=System.currentTimeMillis();
        heapSort(p);                     //---------------------------20ms左右!!!!!
        long end4=System.currentTimeMillis();
        System.out.println("程序运行时间为："+(end4-start4)+"ms");

         print(p);
    }
    //冒泡排序
    public static void bubbleSort(int[] q)
    {
         boolean flag=false;//如果之前已经排序好了就停止(就是没有进行交换操作)
        int i=0;//计算排序的次数

        while(!flag) {
            i++;
            for (int j = 0; j < q.length-1; j++) {
                if (q[j] > q[j + 1])//把小的换到前面去
                {
                    flag = true;
                    int l = 0;
                    l = q[j];
                    q[j] = q[j + 1];
                    q[j + 1] = l;
                }
            }

            flag=!flag;//flag取反,如果排序过则可以继续while，如果没有则停止
//            System.out.printf("第%d遍排序", i);
//            print(q);

        }

    }
    //选择排序算法，时间复杂度O(n²)
    public static void selectSort(int[] q)
    {
        int l = 0;
        for(int i=0;i<q.length;i++)
        {
            for(int j=i;j<q.length;j++)
            {
                if (q[i] > q[j])//把小的换到前面去
                {

                    l = q[i];
                    q[i] = q[j];
                    q[j ] = l;
                }
            }
            //print(q);
        }
    }

    //插入排序算法
    public static void insertSort(int[] q)
    {
        int insertVal=q[0];
        int insertIndex=0;
        for(int i=0;i<q.length;i++)
        {
             insertVal=q[i];
            insertIndex=i-1;
            while(insertIndex>=0&&insertVal<q[insertIndex])//每一个循环里面，把q[i]与它前面的数作比较(因为有insertIndex--)，如果q[i]更小，就把当前这个数与后面的交换
            {                                              //所以每次排序需要涉及前i+1个数，确定一个数的位置
                q[insertIndex+1]=q[insertIndex];           //while结束后，比q[i]大的数都移动到了后面，最后insertIndex停留的位置就是q[i]应该在的位置
                insertIndex--;
            }
//            if(insertIndex+1!=i)//其实从算法来看不需要这个if，但是加了会稍快速一点，会减少一些交换数据的动作
//            {
//                q[insertIndex+1]=insertVal;
//            }
            q[insertIndex+1]=insertVal;
           // print(q);
        }
    }

    //希尔排序的第一种实现方法，交换法.总体思想指数变加数，一个大数拆分为很多个小项，其指数增量会大大减少
    public static void shell_1_Sort(int[] q)
    {
        int temp;
        for(int gap=q.length/2;gap>0;gap/=2)
        {
            for(int i=gap;i<q.length;i++)
            {
                for(int j=i-gap;j>=0;j-=gap)//因为j的外一层是i，i是增加的，所以最内一层for是要从后面往回排序
                {                           //可以参照PDF里的流程图理解
                    if(q[j]>q[j+gap])
                    {
                        temp=q[j];
                        q[j]=q[j+gap];
                        q[gap+j]=temp;
                    }
                }
            }
        }
    }

    //希尔排序的第二章实现方法，体现了插入排序的思想
    public static void shell_2_Sort(int[] q)
    {
        int temp;
        for(int gap=q.length/2;gap>0;gap/=2)
        {
            for(int i=gap;i<q.length;i++)
            {
                int j=i;
                //从这一步开始用到了插入排序的思想：temp=q[j],通过while把大于temp的换到后面，再j--,j最后停留的位置就是temp这个数最终的位置。
                temp=q[j];
                if(q[j]<q[j-gap]) {//这一个判断可以加在while里面的吧？
                    while (j-gap >= 0 && temp < q[j-gap]) {//temp存放的是原q[j]位置的值，每一次while都与变化一个步长后的值比大小，但可能存在比较不充分的情况
                        q[j ] = q[j-gap];
                        j -= gap;
                    }
                    q[j]=temp;

                }
            }
        }
    }

    public static void quickSort(int[] q,int left0,int right0)
    {
        int left=left0;
        int right=right0;

        //left right 是数组q的两个坐标值
        int pivot=q[(left0+right0)/2];//中间值
        int temp;
        while(left<right)//将pivot小的放左边，大的放右边
        {
            //在左边一直找
            while(q[left]<pivot)//这个while里面，把不符合pivot左边小右边大的值全部进行交换。如果左右两边找不到，其index值最终会停留在pivot的那个index位置
            {
                left+=1;        //一种特殊情况：因为每次交换左右两边都贡献一个数。那如果左边有0个符号条件的，右边有一个符合条件的，left最终为停留在pivot index那里，
            }                     //right停留在右边符合条件的那里。交换一次后，右边符合条件的放到pivot index位置，pivot则被交换到右边区域去了。但是left依然小于right
            while(q[right]>pivot) //再一次交换，left其实会向前再走一步，但马上就停了，因为进了大的区域，right则不会变，因为q[right]=pivot,再交换一次,
            {                     //会出现pivot最终的位置比之前往前挪了一步。但总体还是满足左边小右边大的格局。
                right-=1;
            }
            if(left>=right)//while结束的条件，pivot左边全是小于基准值的，右边全是大于基准值的
            {
                break;
            }
            temp=q[left];
            q[left]=q[right];
            q[right]=temp;

            //如果交换后，q[left]==pivot right--
            if(q[left]==pivot)
            {
                right--;
            }
            if(q[right]==pivot)
            {
                left++;
            }
        }
        //如果left==right,则需要分别处理，否则栈溢出
        if(left==right)
        {
         left+=1;
         right-=1;
        }
        //左递归
        if(left0<right)//缩小递归范围
        {
            quickSort(q,left0,right);
        }
        //右递归
        if(right0>left)
        {
            quickSort(q,left,right0);
        }
    }

    //一般的快速排序算法
    public static void quickSort2(int[] arr,int begin,int end)
    {
        if(begin<end)
        {
            int temp = arr[begin]; //将区间的第一个数作为基准数，就不取中间值了
            int i = begin; //从左到右进行查找时的“指针”，指示当前左位置
            int j = end; //从右到左进行查找时的“指针”，指示当前右位置
            //不重复遍历。重复的左右调换可以找到temp值对应的index。
            while(i < j)
            {
                //下面两个while与quickSort1里面的while作用基本相同
                //当右边的数大于基准数时，略过，继续向左查找，直到找到一个小于基准值的
                //不满足条件时跳出循环，此时的j对应的元素是小于基准元素的
                while(i<j && arr[j] > temp)
                    j--;
                //将右边小于等于基准元素的数填入右边相应位置
                arr[i] = arr[j];
                //当左边的数小于等于基准数时，略过，继续向右查找
                //(重复的基准元素集合到左区间)
                //不满足条件时跳出循环，此时的i对应的元素是大于等于基准元素的
                while(i<j && arr[i] <= temp)
                    i++;

                //将左边大于基准元素的数填入左边相应位置
                arr[j] = arr[i];
                //两次交换把左右两边满足条件的交换了位置，但引起了初始arr[i]值的丢失，不过temp已经存好了其值

            }
            //将基准元素填入相应位置
            arr[i] = temp;
            //此时的i即为基准元素的位置
            //对基准元素的左边子区间进行相似的快速排序
            quickSort2(arr,begin,i-1);
            //对基准元素的右边子区间进行相似的快速排序
            quickSort2(arr,i+1,end);

        }else return;
    }
    //归并算法分为两部分：分和并。分由递归完成，递归最深后调用 并 方法。
    public static void mergeSort(int[] arr,int left,int right,int[] temp)
    {
        if(left<right)
        {
            int mid=(left+right)/2;
            //左递归分解
            mergeSort(arr,left,mid,temp);
            //右递归分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }

    }
    //归并算法的并部分
    public static void merge(int[] arr,int left,int mid,int right,int[] temp)
    {

        int i=left,j=mid+1;

        int t=0;
        //归并排序的第一部分：两边分别比较
        while(i<=mid&&j<=right)
        {
            if(arr[i]>arr[j])//参照图解，左右两边一次比较，小的先放进temp里面
            {
                temp[t++]=arr[j++];

            } else {
                temp[t++]=arr[i++];
            }
        }
        /* 归并排序的第二部分：剩余的部分直接补齐到temp后面。实际上只有一边可能有剩余 */
        while(i<=mid)//左边有剩余
        {
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while(j<=right)//右边有剩余
        {
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //第三部分：将temp的数据返回给arr.因为分拆的缘故，所以只复制left到right之间的数据
        //System.out.println("正在归并"+left+"到"+right+"的数据！");
        t=0;int tempLeft=left;
        while(tempLeft<=right)
        {
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }

    }
    //基数排序算法
    public static void radixSort(int[] arr)
    {
       //首先找出最大的数，由最大的数得到它的位数
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        //得到最大数的位数.转成字符串取长度
        int maxLength=(max+"").length();
        //定义一个二维数组，行数为10
        int[][] bucket=new int[10][arr.length];
        //定义一个一维数组记录每个桶每次放入的数据个数。默认的数值都是0
        int[] bucketElementsCounts=new int[10];

        //进行排序，每一次循环处理处理一个位
        for(int i=0,n=1;i<maxLength;i++,n*=10)
        {
            //对整个arr进行遍历，遍历arr.length次，求出对应位的值和每个桶子下的数字个数
            for(int j=0;j<arr.length;j++)
            {
                int digitOfElement=arr[j]/n%10;//将对应位的数值取出来
                //bucket行数是0~9，得出每一位的数值后，按这个数值存数即可（即对应哪个桶子）
                bucket[digitOfElement][bucketElementsCounts[digitOfElement]]=arr[j];
                bucketElementsCounts[digitOfElement]++;//相当于给digitalElement这个桶下的数字编号
            }
            /*
            按照桶子开始重新排序，并存进arr中
            bucketElementsCounts也只有10个数据，这是个数据的和为arr.length
            所以内外两层for可以遍历完所有数据
            */
            int index=0;
            //0~9号桶子依次遍历
            for(int k=0;k<bucketElementsCounts.length;k++)
            {
                //
                if(bucketElementsCounts[k]!=0)
                {
                    //每个桶子的数值大小就是其存放的数据量
                    for(int l=0;l<bucketElementsCounts[k];l++)
                    {
                        //
                        arr[index++]=bucket[k][l];
                    }
                }
                //
                bucketElementsCounts[k]=0;
            }
           /* System.out.println("正在处理第"+i+"位");
           print(arr);*/
        }

    }
    //堆排序，要用二叉树的思想来考虑(实际排序的时候不需要树)
    public static void heapSort(int[] arr)
    {
        int temp=0;
        //1、从底向上开始第一遍
         for(int i=arr.length/2-1;i>=0;i--)
         {
             heapTop(arr,i,arr.length);
         }
        //2.上面已经的到大堆顶二叉树。又待排序数组是升序，所以把最大的数换到最末尾去
        for(int j=arr.length-1;j>0;j--)
        {
            temp=arr[0];
            arr[0]=arr[j];
            arr[j]=temp;
            //下面操作保证堆顶的数是剩下的数中最大的
            heapTop(arr,0,j);
        }

    }
    //堆排序的辅助方法：将堆顶置位最大
    //i为当前叶子结点
    public static void heapTop(int[] arr,int k,int length)
    {
        int temp=arr[k];

        //当前结点左子树纵深循环
        for(int i=2*k+1;i<length;i=i*2+1)
        {
            //i坐标指向左节点
            if(i+1<length&&arr[i]<arr[i+1])//比较左右两个结点，如果右边的大，则换一下
            {
                i++;//i的坐标指向右结点
            }
            if(arr[i]>temp)
            {
                //就把当前结点和子节点交换一下。实际上就是把大的换到堆顶
                arr[k]=arr[i];
                k=i;
            }else {
                break;
            }
        }
        //for循环结束后，将已知大的放在最顶部l，temp就放到它应该的位置
        arr[k]=temp;
    }

    //打印数组的简易方法
    public static void print(int[] q) {

        for(int a:q)
        {
            System.out.printf("%d ",a);
        }
        System.out.println();
    }
}
