package JavaEE.Lambad表达式;

public class EatableDemo {
    public static void main(String[] args) {
        //普通方式
        Eatable e=new Eatableimpl();
        useEatable(e);

        //匿名内部类
        useEatable(new Eatable() {
            @Override
            public void eat(String s) {
                System.out.println("百优感心，万事劳行");
                System.out.println(s);
            }
        });
        //lambad表达式
        useEatable((String s)->{
            System.out.println("百优感心，万事劳行");
            System.out.println(s);
        });
        //有且只有一个参数时，lambad表达式可以省略小括号
        useEatable( s->{
            System.out.println(s);
        });
        //lambad表达式只有一条语句时，可以省略大括号，分号
        useEatable( s->
            System.out.println(s));
    }
    private static void useEatable(Eatable e){
        e.eat("abcdefg");
    }
}
