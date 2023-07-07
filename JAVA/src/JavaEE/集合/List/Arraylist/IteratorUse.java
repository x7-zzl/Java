package JavaEE.集合.List.Arraylist;


import java.util.ArrayList;
import java.util.Collection;

public class IteratorUse {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();

        c.add("hello");
        c.add("world");
        c.add("test");


        //通过集合对象获取迭代器对象

        //判断集合中是否有元素
        for (String s : c) {
            System.out.println(s);
        }
        //E.next()返回迭代中的下一个元素

        //Exception in thread "main" java.util.NoSuchElementException
        //	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1000)
        //	at 集合.Collection.List.Arraylist.IteratorUse.main(IteratorUse.java:23)
//        System.out.println(it.next());
    }

}
