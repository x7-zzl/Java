package JavaEE.泛型.可变参数;

import java.util.List;

public class ListParameter {
    public static void main(String[] args) {
        List<String> list=List.of("胡桃","魈","刻晴");

//        list.add("琴");//UnsupportedOperationException
//        list.remove(1);//UnsupportedOperationException
//        list.set(2,"甘雨");//UnsupportedOperationException

        System.out.println(list);
    }
}
