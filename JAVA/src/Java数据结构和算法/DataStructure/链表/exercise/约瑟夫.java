package Java数据结构和算法.DataStructure.链表.exercise;

public class 约瑟夫 {
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 0) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curent = first;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curent.setNext(first);
            } else {
                curent.setNext(boy);
                boy.setNext(first);
                curent = boy;
            }
        }
    }

    public void deleteBoy(){
        
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}