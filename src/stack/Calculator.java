package stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by asus on 2020/2/15.
 */
public class Calculator {
    public static void main(String[] args) {

    ////这个字符串是转成后缀表达式之后的结果
    //String suffixExpression = "1 4 + 5 * 9 -";
    //List<String> list = getListString(suffixExpression);
    //int res = cal(list);
    //System.out.println("表达式为：" + list + "结果为：" + res);

        String suffixExpression2 = "12+((2-8)*4)-5";
        List<String> list1=toInfixExpressionList(suffixExpression2);
        System.out.println(list1);

        List<String> list2=infixToSuffix(list1);
        System.out.println(list2);


        System.out.println(suffixExpression2+"的结果为："+cal(list2));



    }
    //下面两个方法只作为演示，不是一般性方法
    public static List<String> getListString(String suffixExpression) {
        //uffixExpression
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }


    public static int cal(List<String> ls) {
        Stack<String> stack = new Stack();

        for (String item : ls) {
            //采用正则表达式分拆
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {

                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                }
                stack.push("" + res);
            }

        }
        return Integer.parseInt(stack.pop());
    }

    //中缀表达式转后缀表达式
    //比如1+((2+3)*4)-5 -> 1 2 3 + 4 * 5 -
    public static List<String> infixToSuffix(List<String> list)
    {
        Stack<String> stack1=new Stack<>();
        List<String> list2=new ArrayList<>();
        for(String item:list)//遍历list里面的值
        {
            if(item.matches("\\d+"))//如果是数值则加入list2
            {
                list2.add(item);
            }else if(item.equals("("))
            {
                   stack1.push(item);
            }else if(item.equals(")"))//如果是右括号，则遇到左括号前，将运算符一直加入list2
            {
                while (!stack1.peek().equals("("))
                {
                    list2.add(stack1.pop());
                }
                stack1.pop();//跳转到这里证明stack1中为左括号，必须将其pop掉

            }else
            {
                while(stack1.size()!=0&&operationLevel(item)<=operationLevel(stack1.peek()))//如果当前运算符的优先级比栈顶的小或者相等，则将stack1
                                                                                            //运算符弹入list2,再去与stack1栈顶的运算符比较
                {
                    list2.add(stack1.pop());
                }
                stack1.push(item);
            }


        }
        while(stack1.size()!=0)//将剩余栈里面的运算符加入list2
        {
            list2.add(stack1.pop());
        }
        return list2;
    }


    //运算式拆分，装载到List里面
    public static List<String> toInfixExpressionList(String s) {
        String str;//用于拼接多为数字
        int i = 0;
        char c;//用于采集字符串的每个字符
        List<String> list=new ArrayList<String>();
        do {
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57)//ASCII码判断不是数字
            {
                list.add(""+c);
                i++;
            }else{
                str="";
                while(i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57)
                {
                    str+=c;
                    i++;
                }
                list.add(str);
            }
        }while(i<s.length());
        return list;
    }

  //判断运算符的级别大小
    public static int operationLevel(String s)
    {
        switch (s)
        {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

}
