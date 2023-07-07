package Java数据结构和算法.数据结构和算法__C语言.作业;


public class Parent {
    public String name;
    public Parent next;

    public Parent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parent{" + "姓名:" + name + '}';
    }
}

class SingleList {
    public Parent head = new Parent("");

    public Parent getHead() {
        return head;
    }

    //添加数据
    public void add(Parent parent) {
        Parent temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = parent;
    }

    //先找到倒数第i个病人
    public Parent LastIndex(Parent p, int k) {
        if (p.next == null) {
            return null;
        }
        int size = getLength(p);
        Parent temp = p.next;
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void delete(Parent parent) {
        Parent temp = head;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到此节点");
                break;
            } else if (temp.next.equals(parent)) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    //返回链表的长度，即节点的个数
    public int getLength(Parent head) {
        if (head.next == null) {
            System.out.println("链表为空");
            return 0;
        }
        int length = 0;
        Parent temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //遍历
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Parent temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);

        }

    }

    public static void main(String[] args) {
        Parent parent1 = new Parent("鸢一折纸");
        Parent parent2 = new Parent("本条二亚");
        Parent parent3 = new Parent("时崎狂三");
        Parent parent4 = new Parent("四糸乃");
        Parent parent5 = new Parent("五河琴里");
        Parent parent6 = new Parent("星宫六飨");
        Parent parent7 = new Parent("镜野七罪");
        Parent parent8 = new Parent("八舞夕弦耶俱矢");
        Parent parent9 = new Parent("诱宵美九");
        Parent parent10 = new Parent("夜刀神十香");

        SingleList singleList = new SingleList();

        singleList.add(parent1);
        singleList.add(parent2);
        singleList.add(parent3);
        singleList.add(parent4);
        singleList.add(parent5);
        singleList.add(parent6);
        singleList.add(parent7);
        singleList.add(parent8);
        singleList.add(parent9);
        singleList.add(parent10);

        System.out.println("原医院门诊平均每天接诊的发热病人姓名:");
        singleList.list();
        System.out.println("发热病人的数量:");
        System.out.println(singleList.getLength(singleList.getHead()));


        Parent parent = singleList.LastIndex(singleList.head, 3);
        //获取要删除的对象
        System.out.println("要删除的病人姓名:");
        System.out.println(parent);
        //删除该对象
        singleList.delete(parent);
        System.out.println("删除后:");
        singleList.list();
    }
}