package Java数据结构和算法.数据结构和算法__C语言.作业;

class A {
    public int anInt;
    public A next;

    public A(int anInt) {
        this.anInt = anInt;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "A{" + anInt + '}';
    }
}

class B {
    public int anInt;
    public B next;

    public B(int anInt) {
        this.anInt = anInt;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "B{" + anInt + '}';
    }
}

class C {
    public int anInt;
    public C next;

    public C(int anInt) {
        this.anInt = anInt;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String toString() {
        return "C{" + anInt + '}';
    }
}

class SingleListA {
    public A head = new A(0);
    public B b=new B(0);
    public C c=new C(0);
    public void addA(A a) {
        A temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = a;
    }

    public void listA() {
        A temp = head;
        while (temp.next != null) {

            if(temp.getAnInt()<0){
                if (b!=null){
                    b.setAnInt(temp.getAnInt());
                    b=b.next;
                }

            }else if(temp.getAnInt()>0){
                if (c!=null){
                    c.setAnInt(temp.getAnInt());
                    c=c.next;
                }

            }
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void listB(){
        B temp = b;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        A a1 = new A(-10);
        A a2 = new A(-1);
        A a3 = new A(2);
        A a4 = new A(13);
        A a5 = new A(17);
        SingleListA singleA = new SingleListA();
        singleA.addA(a1);
        singleA.addA(a2);
        singleA.addA(a3);
        singleA.addA(a4);
        singleA.addA(a5);
        singleA.listA();




    }
}
