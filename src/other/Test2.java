package other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * Created by asus on 2020/2/26.
 * 4399笔试题第三题：求两个日期是否为同一天
 * 
 */

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();//测试用例个数
        while(scanner.hasNextLine()) {
            //获取6个中整数
            int y1 = scanner.nextInt(), m1 = scanner.nextInt(), d1 = scanner.nextInt();
            int y2 = scanner.nextInt(), m2 = scanner.nextInt(), d2 = scanner.nextInt();
            //转成两个年份格式
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            s1.append(String.valueOf(y1));
            s1.append("/");
            s2.append(String.valueOf(y2));
            s2.append("/");

            if (m1 < 10) {//拼接月份
                s1.append(String.valueOf(0));
                s1.append(String.valueOf(m1));
            } else {
                s1.append(String.valueOf(m1));
            }
            s1.append("/");
            if (m2 < 10) {//拼接月份
                s2.append(String.valueOf(0));
                s2.append(String.valueOf(m2));
            } else {
                s2.append(String.valueOf(m2));
            }
            s2.append("/");

            if (d1 < 10) {//拼接日期
                s1.append(String.valueOf(0));
                s1.append(String.valueOf(d1));
            } else {
                s1.append(String.valueOf(d1));
            }
            if (d2 < 10) {//拼接日期
                s2.append(String.valueOf(0));
                s2.append(String.valueOf(d2));
            } else {
                s2.append(String.valueOf(d2));
            }
            System.out.println(getSubTime(s1.toString(), s2.toString()));

        }

    }

    public static boolean getSubTime(String date3, String date4) {
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

        if ((time3 / (86400000)) % 7 == 0) {
            return true;
        } else {
            return false;
        }


    }
}
