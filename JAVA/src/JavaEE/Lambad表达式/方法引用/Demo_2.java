package JavaEE.Lambad表达式.方法引用;
//类实例方法语法使用例子
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

public class Demo_2 {
    @Test
    public void test() {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");

        //对象实例语法	instanceRef::methodName
        list.forEach(new Demo_2()::print);
    }

    public void print(String content){
        System.out.println(content);
    }
}
