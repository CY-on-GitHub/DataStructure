package recursion;

/**
 * Created by asus on 2020/2/16.
 * 递归解决迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {

        //创建一个二维迷宫
        int[][] map=new int[8][7];
        //设置边界，上下为1
        for(int i=0;i<7;i++)
        {
            map[0][i]=1;
            map[7][i]=1;
        }//左右为1
        for(int j=0;j<8;j++)
        {
            map[j][0]=1;
            map[j][6]=1;
        }

        map[3][1]=1;map[3][2]=1;//设置内部墙体
        map[4][4]=1;map[5][4]=1;map[6][4]=1;
        //输出地图
        System.out.println("输出原地图");
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<7;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.print("\n");
        }
        //输出迷宫回溯后的地图
        System.out.println("输出回溯后地图");
        System.out.println(setWay(map,1,1));
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<7;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.print("\n");
        }


    }
    /*
    * map为地图
    * ij 为初始坐标
    * 目标能到[6,5]的位置则可以
    * map[i,j]=0表示为走过，map[i,j]=1表示墙体，map[i,j]=2时表示可通行，=3表示已走路径
    * 策略，预设方向下-》右-》上-》左
    * */

    public static boolean setWay(int[][] map,int i,int j)
    {

        if(map[6][5]==2)//注意：这里是递归终止点，最后递归从下面多个if else中跳出，结束
        {             //这里的终止条件会导致最后那条路径不被设置为2
            //迷宫走完
            return true;
        }else if(map[i][j]==0)//可以继续走
        {
            map[i][j]=2;
            if(setWay(map,i+1,j))//向下走
            {
                System.out.println("运行到这里结束-下");
                return true;//这里面的return true需要仔细思考
            }else if(setWay(map,i,j+1))//向右走
            {
                System.out.println("运行到这里结束-右");
                return true;
            }else if(setWay(map,i-1,j))//向上走
            {
                System.out.println("运行到这里结束-上");
                return true;
            }else if(setWay(map,i,j-1))//向左走
            {
                System.out.println("运行到这里结束-左");
                return true;
            }else{
                map[i][j]=3;//走不通，是死路.这条代码在需要原路返回找其他路的时候有用
                return false;
            }
        }else {
            //map[i][j]为其他值
            return false;
        }

    }
}
