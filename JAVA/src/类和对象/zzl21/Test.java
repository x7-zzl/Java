package 类和对象.zzl21;
class A{
    A(){
        System.out.print("中国");
    }
}

class B extends A{
    B(){
        System.out.print("武汉");
    }
}

class C extends B{
    C(){
        System.out.print("加油");
    }
}


public class Test {
    public static void main(String args[]){
        C c=new C();
    }

}
