package Java数据结构和算法.DataStructure.树.二叉树.二叉树计算器;

public class LinkStack {
    private Node top;

    //将栈置空
    public void clear() {
        // TODO Auto-generated method stub
        top = null;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return top == null;
    }

    //求栈的长度
    public int length() {
        // TODO Auto-generated method stub
        Node p = top;
        int length = 0;
        while (p != null) {
            p = p.next;
            ++length;
        }
        return length;
    }

    //取栈顶元素并返回其值
    public Object peek() {
        // TODO Auto-generated method stub
        if (!isEmpty())
            return top.date;
        else
            return null;
    }

    //入栈
    public void push(Object x) throws Exception {
        // TODO Auto-generated method stub
        Node p = new Node(x);
        p.next = top;
        top = p;
    }

    //出栈
    public Object pop() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return null;
        } else {
            Node p = top;
            top = top.next;
            return p.date;
        }
    }

    //输出栈中所有数据元素（顶到底）
    public void display() {
        Node p = top;
        while (p != null) {
            System.out.print(p.date.toString() + " ");
            p = p.next;//指针后移
        }
    }
}

