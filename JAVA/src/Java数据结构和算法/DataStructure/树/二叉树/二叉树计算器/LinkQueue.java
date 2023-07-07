package Java数据结构和算法.DataStructure.树.二叉树.二叉树计算器;

public class LinkQueue {
    private Node front;//队首指针
    private Node rear;//队尾指针

    //构造函数
    public LinkQueue() {
        // TODO Auto-generated constructor stub
        front = rear = null;
    }

    //队列置空
    public void clear() {
        // TODO Auto-generated method stub
        front = rear = null;
    }

    //判空
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return front == null;
    }

    //求队列长度
    public int length() {
        // TODO Auto-generated method stub
        Node p = front;
        int length = 0;
        while (p != null) {
            p = p.next;
            ++length;
        }
        return length;
    }

    //取队首元素
    public Object peek() {
        // TODO Auto-generated method stub
        if (front != null)
            return front.date;
        else
            return null;
    }

    //入队
    public void offer(Object x) throws Exception {
        // TODO Auto-generated method stub
        Node p = new Node(x);
        if (front != null) {
            rear.next = p;
            rear = p;
        } else {
            front = rear = p;
        }
    }

    //出队
    public Object poll() {
        // TODO Auto-generated method stub
        if (front != null) {
            Node p = front;
            front = front.next;
            if (p == rear)
                rear = null;
            return p.date;
        } else
            return null;
    }

}
