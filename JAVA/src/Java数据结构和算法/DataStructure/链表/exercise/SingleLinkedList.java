package Java数据结构和算法.DataStructure.链表.exercise;

public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "小埋", "umr");
        HeroNode heroNode2 = new HeroNode(4, "玉子", "tamako");
        HeroNode heroNode3 = new HeroNode(3, "时崎狂三", "nightmare");
        HeroNode heroNode4 = new HeroNode(2, "古河渚", "najisa");


        SingleLinkedList singleLinkedList = new SingleLinkedList();


//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
//        singleLinkedList.list();

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode4);

        singleLinkedList.update(new HeroNode(3, "年糕娘", "tamako"));
//        singleLinkedList.list();
//
//        singleLinkedList.delete(1);
//        singleLinkedList.delete(2);

        singleLinkedList.list();
    }


    //反转


    public static int getLength(HeroNode head) {
        if (head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }


    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加
    public void add(HeroNode heroNode) {

        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按顺序放入链表中
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;

        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {

            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改
    public void update(HeroNode newHero) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;

        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.no == newHero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHero.name;
            temp.nickname = newHero.nickname;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHero.no);
        }

    }

    //删除
    public void delete(int no) {

        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) { //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

    //遍历
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空!!!");
            return;
        }


        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}