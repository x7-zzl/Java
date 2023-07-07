package JavaEE.Lambad表达式.方法引用;

import org.junit.Test;
//类构造器语法使用例子
public class Example {

    @Test
    public void test() {
        InterfaceExample com =  Example::new;
        Example bean = com.create();
        System.out.println(bean);
    }
}

interface InterfaceExample{
    Example create();
}
