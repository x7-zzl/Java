package JavaEE.集合.List.Arraylist;

import java.util.ArrayList;

public class Arraylist1 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        //向集合中添加元素
        arr.add("hello");
        arr.add("java");
        arr.add("get");
        //在索引为1处的地方增加元素"updown"
//        arr.add(1, "updown");
        //集合越界：IndexOutOfBoundsException
//        arr.add(10,"guole");

//        //输出移除的元素（在索引为1处）
//        System.out.println(arr.remove(1));
//
//       //移除元素"java"， 返回true
//        System.out.println(arr.remove("java"));
//        //移除元素"victory"，返回false
//        System.out.println(arr.remove("victory"));
        //把索引为1的元素"java"改为"ssr"
        System.out.println(arr.set(1, "ssr"));

        System.out.println(arr.get(0));
        System.out.println(arr.get(1));
        System.out.println(arr.get(2));
        //集合越界：IndexOutOfBoundsException
//        System.out.println(arr.get(8));

        System.out.println("集合中元素为:" + arr);
        System.out.println("集合中元素个数:" + arr.size());
    }
}
