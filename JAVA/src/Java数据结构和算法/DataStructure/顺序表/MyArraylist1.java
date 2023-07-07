package Java数据结构和算法.DataStructure.顺序表;

import java.util.Arrays;

public class MyArraylist1 {
    public int[] elem;//存储数据的有效个数
    public int usedata;//有效数据的个数

    //构造方法
    public MyArraylist1() {
        this.elem = new int[10];
    }

    public void add(int pos, int data) {
        //1.判断顺序表是否为满
        if (this.elem.length == this.usedata) {
            System.out.println("满了，扩充");
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        //2，pos位置有效性
        if (pos < 0 || pos > this.usedata) {
            System.out.println("不合法");
            return;
        }
        //3,插入
        for (int i = this.usedata - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        usedata++;
    }

    //查找一个元素返回下标
    public int search(int tofind) {
        //1.判断顺序表是否为空
        if (this.usedata == 0) {
            throw new RuntimeException("顺序表为空");
        }
        //2.查找
        for (int i = 0; i < this.usedata; i++) {
            if (this.usedata == tofind) {
                return i;
            }
        }
        return -1;
    }

    //删除第一次出现的关键字toRemove
    public void remove(int toRemove) {
        //1.判断是否含有这个关键字
        int index = search(toRemove);
        if (index == -1) {
            System.out.println("删除的关键字不存在");
            return;
        }
        //2.删除
        //主要理解i< this.usedsize-1，画图易懂，比如有1,2,3三个数，要删除0号下标，i=0;i<2;i++,从后向前覆盖两次。
        for (int i = index; i < this.usedata - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        usedata--;
    }


    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        //1.判断顺序表是否为空
        if (this.usedata == 0) {
            throw new RuntimeException("顺序表为空");
        }
        //2.判断pos位置有效性
        if (pos < 0 || pos >= this.usedata) {
            return;
        }
        //3.修改值为value
        this.elem[pos] = value;
    }

    //打印元素
    public void display() {
        for (int i = 0; i < this.usedata; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyArraylist1 myArraylist1 = new MyArraylist1();
        myArraylist1.add(0, 1);
        myArraylist1.add(0, 2);
        myArraylist1.add(0, 3);
        myArraylist1.add(0, 4);
        myArraylist1.add(0, 5);
        System.out.println("========================查找===========================");
        myArraylist1.display();
        System.out.println("查找元素下标为：" + myArraylist1.search(1));
        System.out.println("查找元素下标为：" + myArraylist1.search(3));
        System.out.println("查找元素下标为：" + myArraylist1.search(5));
        System.out.println("========================删除===========================");
        myArraylist1.remove(1);
        myArraylist1.remove(5);
        myArraylist1.display();
        System.out.println("========================修改===========================");
        myArraylist1.setPos(0, 2);
        myArraylist1.setPos(2, 4);
        myArraylist1.display();
    }
}