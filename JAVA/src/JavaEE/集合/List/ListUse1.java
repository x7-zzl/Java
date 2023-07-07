package JavaEE.集合.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListUse1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");

        list.add(1,"javaee");
        //list集合的遍历
        for (int i=0;i<list.size();i++){
            String s=list.get(i);
            System.out.println(s);
        }
        list.remove(2);

        list.set(2,"YuHan");

        //list集合的遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String  s=it.next();
            System.out.println(s);
        }
    }
}
