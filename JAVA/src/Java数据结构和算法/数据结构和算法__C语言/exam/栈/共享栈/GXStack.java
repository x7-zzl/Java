package Java数据结构和算法.数据结构和算法__C语言.exam.栈.共享栈;


public class GXStack {
    int[] elem;
    int stackSize;
    int top1, top2;

    public GXStack(int stackSize) {
        this.stackSize = stackSize;
        elem = new int[stackSize];
        top1 = -1;
        top2 = stackSize;
    }

    //入栈，选择入哪一个栈
    public void push(int i, int value) {
        if (top1 == top2 - 1) {
            System.out.println("栈满");
            return;
        }

        if (i == 1) {//入栈1
            top1++;
            elem[top1] = value;
        } else if (i == 2) {
            top2--;
            elem[top2] = value;
        } else {
            System.out.println("错误");
        }
    }


    //出栈
    public int pop(int i) throws Exception {
        if (i == 1) {
            if (top1 == -1) {
                throw new Exception("栈1为空");
            }
            int t = elem[top1];
            top1--;
            return t;

        } else if (i == 2) {
            if (top2 == stackSize) {
                throw new Exception("栈2为空");
            }
            int t = elem[top2];
            top2++;
            return t;
        } else {
            System.out.println("错误");
        }
        return -1;
    }

    //遍历

    public void show() {
        for (int i = 0; i < stackSize; i++) {
            System.out.print(elem[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GXStack gxStack = new GXStack(10);
        gxStack.push(1, 4);
        gxStack.push(2, 5);
        gxStack.push(1, 7);
        gxStack.push(1, 1);
        gxStack.push(2, 90);

        gxStack.show();

    }
}