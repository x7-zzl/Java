package JavaEE.集合.List.Arraylist;

import java.util.ArrayList;
import java.util.Collection;

//Alt+7 打开窗口，可以查看类中信息
public class ArrayListDemo {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<String>();

        //输出返回值true，表示存在成功
        System.out.println("添加hello:"+c.add("hello"));
        c.add("world");
        c.add("test");
        //输出返回值true，表示存在成功
        System.out.println("删除test:"+c.remove("test"));

        //判断集合中是否存在元素
        c.contains("world");
        //元素个数
        System.out.println("集合中元素个数为:"+c.size());
        System.out.println(c);


        //清空集合
        c.clear();
        System.out.println("清空后的集合:"+c);
        //判断集合是否为空
        System.out.println("集合是否为空:"+c.isEmpty());
    }
}
