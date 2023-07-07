package Java数据结构和算法.DataStructure.树.二叉树.二叉树计算器;

public class Node {
    public Object date;//存放节点值
    public Node next;//后继节点的引用

    //无参数时的构造函数
    public Node() {
        this(null, null);
    }

    //带一个参数时的构造函数
    public Node(Object date) {
        this(date, null);
    }

    //带两个参数的构造函数
    public Node(Object date, Node next) {
        this.date = date;
        this.next = next;
    }
}

