package JavaEE.集合.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListUse {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");


        System.out.println("增强for循环:");
        for (String s:list){
            System.out.println(s);
        }
        //并发修改异常，元素的修改导致其与预期的元素个数不同
        //解决方法：用for循环遍历
        //Exception in thread "main" java.util.ConcurrentModificationException
        //	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1043)
        //	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:997)
        //	at 集合.Collection.List.ListUse.main(ListUse.java:19)

//        Iterator<String> it = list.iterator();
//        try {
//            while (it.hasNext()) {
//                String s = it.next();
//                if (s.equals("hello")) {
//                    list.add("yn");
//                }
//                System.out.println(s);
//            }
//        } catch (ConcurrentModificationException e) {
//            System.out.println(e);
//        }


        //遍历时加入元素

        System.out.println("-------------");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("hello")) {
                list.add("yn");
            }
//            System.out.println(s);
        }
        System.out.println(list);


        System.out.println("-------------");
        //遍历时加入元素
        ListIterator<String> lit = list.listIterator();
        //通过List集合专有的迭代器进行添加元素,遍历时不会产生并发异常
        while (lit.hasNext()){
            String s = lit.next();
            if (s.equals("hello")) {
                lit.add("adc");
            }
//            System.out.println(s);
        }
        System.out.println(list);
        }


    }




