package JavaEE.集合.List.LinkedList;

import java.util.LinkedList;

public class LinkedListUse
{
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<String>();

        list.add("hello");
        list.add("world");
        list.add("java");
        list.addFirst("11111");
        System.out.println(list.getFirst());
        System.out.println("---------------");
        for (String s:list){
            System.out.println(s);
        }
        System.out.println("---------------");

        list.addLast("momoomomomo");

        System.out.println(list.getLast());
        System.out.println("---------------");
        list.removeLast();
        for (String s:list){
            System.out.println(s);
        }


    }
}
