package JavaEE.Lambad表达式;
//方法引用符：：
public class Addabledemo {
    public static void main(String[] args) {
        //方法引用符：：
//        use((int x,int y)->{//参数的类型可以省略
//            return x+y;
//        } );

        //参数的类型可以省略
        use(Integer::sum);

        //lambad表达式只有一条语句时，可以省略大括号，分号,return也可以省略
        use((int x,int y)-> x+y);
        new Thread(()-> System.out.println("多线程")).start();
    }
    public static void use(Addable a){
        int sum=a.add(10,20);
        System.out.println(sum);
    }
}
