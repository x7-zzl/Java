package JavaEE.集合.List;

//增强for循环，其内部其实是一个迭代器

import java.util.ArrayList;
import java.util.List;

public class ZengQiangFor {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        for (int i:arr){
            System.out.println(i);
        }

        System.out.println("----------");

        String[] sArr={"HELLO","WORLD","YXN"};
        for (String s:sArr){
            System.out.println(s);
        }

        System.out.println("集合----------");

        List<String> list=new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        for (String s:list){
            System.out.println(s);
        }
    }
}
