package Java数据结构和算法.数据结构和算法__C语言.exam.栈;

//模拟栈数据结构
public class Stack{
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
    public String returnTop() {
        //当top=-1时，返回栈顶元素
        if (top == -1) {
            return String.valueOf(0);
        }
        return stack[top];
    }
}