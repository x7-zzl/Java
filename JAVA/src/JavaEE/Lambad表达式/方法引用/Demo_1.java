package JavaEE.Lambad表达式.方法引用;
/*静态方法引用（static method）语法：classname::methodname 例如：Person::getAge
        对象的实例方法引用语法：instancename::methodname 例如：System.out::println
        对象的超类方法引用语法： super::methodname
        类构造器引用语法： classname::new 例如：ArrayList::new
        数组构造器引用语法： typename[]::new 例如： String[]:new
      */
//静态方法语法使用例子
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Demo_1 {
    @Test
    public void test() {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");

        //静态方法语法	ClassName::methodName
        list.forEach(Demo_1::print);

        System.out.println(list);
    }

    public static void print(String content){
        System.out.println(content);
    }
}
