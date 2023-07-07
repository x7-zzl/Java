package Java数据结构和算法.数据结构和算法__C语言.逆波兰计算器;

/*
实现一个简单的计算器，输入一个包含圆括号、加、减、乘、除、求余等符号组成的算术表达式字符串，输出该算术表达式的值。要求：
        （1）系统至少能实现加、减、乘、除、求余等运算；
        （2）利用栈的后进先出特性实现；
        （3）先将输入的算术表达式转换为后缀表达式，并输出后缀表达式；
        （4）利用后缀表达式输出表达式的计算结果。
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//模拟栈数据结构
class Stack {
    int maxsize;//栈的大小
    //字符数组模拟栈
    // 因为在运算过程可能出现运算符或者多位整数，不适合使用char[]和int[]数组
    String[] stack;
    int top = -1;//栈顶

    public Stack(int maxsize) {
        this.maxsize = maxsize;
        stack = new String[this.maxsize];
    }

    //栈满
    public boolean isFull() {
        return top == maxsize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈的方法，参数为String类型
    public void push(String data) {
        //判断是否栈满
        if (isFull()) {
            System.out.println("你输入的表达式太长");
            return;
        }
        top++;
        stack[top] = data;
    }

    //出栈
    public String pop() {
        if (isEmpty()) {
            //通过抛出异常的方式
            throw new RuntimeException("无数据");
        }
        String data = stack[top];
        top--;
        return data;
    }

    //返回栈的顶部数据，不删除数据
    public String returnTop() throws Exception {
        if (isEmpty()) {
            //通过抛出异常的方式
            throw new RuntimeException("无数据");
        }
        //当top=-1时，返回栈顶元素

        return stack[top];
    }
}

//实现计算器的功能类
public class Calculator {
    public static void main(String[] args) throws Exception {
        //输入一个算式,即中缀表达式的形式，例：1+((2+3)*4)-5
        Scanner in = new Scanner(System.in);
        String binaryOperation = in.nextLine();

        //先把中缀表达式分开放入Arraylist集合中
        List<String> niFixExpressionToArrayList = 中缀表达式转成对应的集合(binaryOperation);
        System.out.println("中缀表达式转成对应的集合为:" + niFixExpressionToArrayList);
        //将中缀表达式转换为后缀表达式
        List<String> niFixExpressionsConvertedToPostfixExpression = 中缀表达式转换为后缀表达式(niFixExpressionToArrayList);
        System.out.println("后缀表达式:" + niFixExpressionsConvertedToPostfixExpression);

        //通过后缀表达式计算结果
        System.out.printf("结果为:%d", calculate(niFixExpressionsConvertedToPostfixExpression));

    }

    //将中缀表达式转成对应的ArrayList集合的方法
    public static List<String> 中缀表达式转成对应的集合(String s) {
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        StringBuilder str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，我需要加入到ls
            if((c=s.charAt(i)) < 48 ||  (c=s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //i需要后移
            } else { //如果是一个数，需要考虑多位数
                str = new StringBuilder(); //先将str 置成"" '0'[48]->'9'[57]
                while(i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57) {
                    str.append(c);//拼接
                    i++;
                }
                ls.add(str.toString());
            }
        }while(i < s.length());
        return ls;//返回
    }

    //将中缀表达式转换为后缀表达式的方法
    public static List<String> 中缀表达式转换为后缀表达式(List<String> stringList) throws Exception {
        //用来存放数据的栈，大小设置为100
        Stack s1 = new Stack(100);
        //定义ArrayList集合来储存中间结果
        List<String> s2 = new ArrayList<String>();
        for (String index : stringList) {
            //通过使用正则表达式来进行匹配
            //如果是一个数，加入s2
            if (index.matches("\\d")) {
                s2.add(index);
            } else if (index.equals("(")) {
                //如果是左括号，直接入栈
                s1.push(index);
            } else if (index.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!(s1.returnTop().equals("("))) {
                    s2.add(s1.pop());
                }
                //将"("弹出s1栈,消除括号
                s1.pop();
            } else {
                //当index的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，
                // 然后index再次与s1中新的栈顶运算符相比较
                while (!s1.isEmpty() && OperationPriority.getValue(s1.returnTop()) >= OperationPriority.getValue(index)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(index);
            }

        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //返回运算符的优先级
//    public static int getOperationPriority(String operation) {
//        //通过返回result的值，来实现符号优先级的比较
//        int result = 0;
//        switch (operation) {
//            case "+":
//            case "-":
//                result = 1;
//                break;
//            case "*":
//            case "x":
//            case "/":
//                result = 2;
//                break;
//        }
//        return result;
//    }

    //通过后缀表达式计算结果
    private static int calculate(List<String> resultList) {
        //用来存放数据的栈，大小设置为100
        Stack stack = new Stack(100);
        // 遍历
        for (String index : resultList) {
            // 使用正则表达式来取出数
            if (index.matches("\\d+")) {
                // 入栈
                stack.push(index);
            } else {
                // pop出两个数，并运算,再入栈
                //出栈的数据为String类型，转换为整数型
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result;
                //因为从栈中取出的数据是先入后出
                //计算算式的结果是应该注意先后的顺序
                switch (index) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        //用户可以输入两种乘号
                        break;
                    case "*":
                    case "x":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    case "%":
                        result = num2 % num1;
                        break;
                    default:
                        throw new RuntimeException("你输入的运算符有误");
                }
                //把result入栈
                stack.push("" + result);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类 OperationPriority 可以返回运算符 对应的优先级
class OperationPriority {
    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
            case "-":
                result = 1;
                break;
            case "*":
            case "/":
            case "%":
                result = 2;
                break;

        }
        return result;
    }

}