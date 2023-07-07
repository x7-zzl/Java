package JavaEE.泛型.泛型实例;
//泛型类，泛型方法，泛型接口，参数类型
//泛型，通过方法可以传递任意类型的参数
public class Generic {
    public <T> void show(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        Generic g=new Generic();
        g.show("影");
        g.show(20);
        g.show("女");
        g.show(177.9);
        g.show(81+","+55+","+83);
        System.out.println("-------------------");
        Generic g1=new Generic();
        g1.show("胡桃");
        g1.show(19);
        g1.show("女");
        g1.show(168.9);
        g1.show(77+","+50+","+73);
    }
}
