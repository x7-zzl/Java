package JavaEE.Lambad表达式.方法引用;

public class Example_2 {

    private String name;

    Example_2(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        InterfaceExample_2 com = Example_2::new;
        Example_2 bean = com.create("hello world");
        System.out.println(bean.name);
    }
}

interface InterfaceExample_2 {
    Example_2 create(String name);
}
