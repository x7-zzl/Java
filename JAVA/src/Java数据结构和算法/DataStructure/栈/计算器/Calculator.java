package Java数据结构和算法.DataStructure.栈.计算器;

public class Calculator {
    public static void main(String[] args) {
        //先创建两个栈，一个存放数字，一个存放运算符
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;  //这是指针，指向当前表达式的位置
        int num1 = 0;
        int num2 = 0;
        String expression = "10-2-2*(5+10)+8-(21+3)*2";        //14+28=42

        //入栈
        while(1 == 1){
            char ch = expression.substring(index, index+1).charAt(0);   //得到当前指针所指的字符串内容
            //判断是符号还是数字
            if(operStack.isOper(ch)){   //如果是符号
                if(!operStack.isEmpty()){   //如果符号栈不为空
                    if(ch == '('){  //如果是'('号，则直接将'('号入栈
                        operStack.push(ch);
                        //跳出循环
                        index ++;
                        if(index >= expression.length()){
                            break;
                        }
                        continue;
                    }else if(ch == ')'){    //如果是')'号，需要将 '('号之前的东西都进行计算，将结果压入数栈
                        //返回操作栈的栈顶的数据
                        int operation = operStack.peek();
                        while (operation != '('){
                            //小于就要从数栈中出两个数据，和栈顶元素进行运算
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            int oper = operStack.pop();
                            int result = operStack.calculate(num1, num2, oper);
                            //把运算的结果再入栈
                            numStack.push(result);
                            operation = operStack.peek();
                        }
                        operStack.pop();
                        //跳出循环
                        index ++;
                        if(index >= expression.length()){
                            break;
                        }
                        continue;
                    }
                    //如果当前符号优先级小于或者等于栈顶的符号，这里要反复的进行比较，
                    //原因： 2-2*5+10 这个表达式进行运算，如果这里的最后一个'+'号，如果只与前面的'*'号比较，
                    //那进行运算的后的结果是 2-10+10，这时'+'号入符号栈，在最后出栈进行运算时，数栈中此时
                    //数据为 [2 10 10] 符号栈数据为 [- +]，进行运算时首先出来的 是 10+10，计算结果20压入数栈
                    // ，然后是2-20,这显然不符合运算规则
                    while (!operStack.isEmpty() && operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        //小于就要从数栈中出两个数据，和栈顶元素进行运算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        int oper = operStack.pop();
                        int result = operStack.calculate(num1, num2, oper);
                        //把运算的结果再入栈
                        numStack.push(result);
                    }
                    operStack.push(ch);
                }else{  //符号栈为空则直接入栈
                    operStack.push(ch);
                }
            }else{  //如果是数字，那就直接入栈
                if(index+1 == expression.length()){
                    numStack.push(ch - 48);
                }else{
                    //如果是多位数
                    int temp = index+1;   //获取当前表达式的下一个索引
                    char multi = expression.substring(temp, temp+1).charAt(0);  //多位数进行拼接的元素
                    String num = String.valueOf(ch);    //数字的第一个
                    while(!operStack.isOper(multi)){    //当不是运算符时，需要拼接字符串
                        num += multi;   //这里进行拼接
                        temp = temp + 1;    //下一个索引
                        index++;    //这个相应的全局指针也要后移！！！！！！！！！
                        if(temp < expression.length()){ //小于则直接拆分赋值
                            multi = expression.substring(temp, temp+1).charAt(0);
                        }else if(temp == expression.length()){  //到了表达式的末尾，直接退出循环
                            break;
                        }
                    }
                    numStack.push(Integer.parseInt(num));
                    //numStack.push(ch - 48); //因为是char型，char型的'1'对应ascii码表的49，所以要减48
                }

            }

            //跳出循环
            index ++;
            if(index >= expression.length()){
                break;
            }
        }

        //入栈结束后，就要逐个的进行计算了
        while (1==1){
            //当运算符栈空时，代表计算结束
            if(operStack.isEmpty()){
                int result = numStack.pop();    //这时的栈顶是计算后的结果
                System.out.printf("%s = %d", expression, result);
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            int oper = operStack.pop();
            int result = operStack.calculate(num1, num2, oper);
            //把运算的结果再入栈
            numStack.push(result);
        }
    }
}

class ArrayStack2{
    private int maxSize;    //栈的大小
    private int[] stack;   //定义栈
    private int top = -1;    //栈顶,一定要初始化为-1,不然就有默认值0了

    //初始化栈的大小
    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int data){
        //栈满时，不能入栈
        if(isFull()){
            System.out.println("栈满~~不能入栈");
            return;
        }
        top ++;
        stack[top] = data;
    }
    //出栈
    public int pop(){
        //栈空，不能出栈
        if(isEmpty()){
            throw new RuntimeException("栈空~~，莫得数据");
        }
        //定义中间值接收栈顶元素值
        int temp = stack[top];
        top --;
        return temp;
    }
    //输出栈（遍历栈），不过是反向遍历数组
    public void stackList(){
        //当栈空时，不需要遍历
        if(isEmpty()){
            System.out.println("栈空~莫得数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
    //返回栈顶的数据,但并不出栈，也就是说top指针并不移动
    public int peek(){
        return stack[top];
    }
    //判断是否是运算符
    public boolean isOper(int oper){
        return oper == '+' || oper == '-' || oper == '*' || oper == '/' || oper == '(' || oper == ')';
    }
    //加减乘除的优先级
    public int priority(int oper){
        if(oper == '*' || oper == '/'){ //优先级最高的
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;  //错误的运算符
        }
    }
    //进行运算
    public int calculate(int num1, int num2, int oper){
        int result = 0;
        switch (oper){  //进行正常的运算
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;   //这里要注意运算的优先级
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}