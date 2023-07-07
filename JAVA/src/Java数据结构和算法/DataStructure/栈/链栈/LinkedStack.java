package Java数据结构和算法.DataStructure.栈.链栈;


//1、定义类属性和构造函数
public class LinkedStack {

    private int[] data = new int[1]; //存储元素值

    private LinkedStack nextStack;  //存储下一地址

    public LinkedStack() {  //用于生成头结点
        this.data = null;
        this.nextStack = null;
    }

    public LinkedStack(int data) { //用于生成链栈结点
        this.data[0] = data;
        this.nextStack = null;
    }


    //        2、清空链栈
    public void clearStack() {
        this.nextStack = null;  //令头结点的下一地址为空，链栈即被清空
    }

    //        3、检测链栈是否为空
    public boolean stackEmpty() {
        if (this.nextStack == null) { //判断头结点的下一地址是否为空即可
            return true;
        }
        return false;
    }
//        4、返回链栈中的元素个数

    public int stackLength() {

        LinkedStack theStack = this.nextStack; //获取头结点的下一地址即链栈的第一个结点
        int i = 0; //初始化计数器

        for (i = 0; theStack != null; i++) {//循环判断如不为空，则计数器加一
            theStack = theStack.nextStack;
        }
        return i;
    }

//        5、返回链栈的栈顶元素，不修改栈指针

    public int[] getTop() {

        if (this.nextStack == null) { //判断是否为空栈
            return null;
        }

        return this.nextStack.data;
    }

    //        6、向链栈顶压入元素
    public void push(int input) {
        LinkedStack linkedStack = new LinkedStack(input);
        linkedStack.nextStack = this.nextStack;
        this.nextStack = linkedStack;
    }
//        7、从链栈顶弹出元素

    public int[] pop() {

        if (this.nextStack == null) {  //判断栈是否为空
            return null;
        }

        int[] i = this.nextStack.data;   //获取栈顶元素值
        this.nextStack = this.nextStack.nextStack;  //删除栈顶元素
        return i;
    }

    //        8、从栈底到栈顶遍历链栈
    public String stackTraverse() { //这里通过输出栈元素值来表示遍历

        LinkedStack theStack = this.nextStack;
        String s = "";

        while (theStack != null) { //循环遍历栈
            s = theStack.data[0] + "、" + s;
            theStack = theStack.nextStack;
        }

        if (s.length() == 0) { //如果未获得值，则直接输出空字符串
            return s;
        }
        return s.substring(0, s.length() - 1);//除去最后的顿号后返回字符串
    }
}