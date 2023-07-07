package JavaEE.泛型.可变参数;

import java.util.Arrays;
import java.util.List;

public class ArraysParameter {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("胡桃","魈","刻晴");

//        list.add("琴");//UnsupportedOperationException
//        list.remove(1);//UnsupportedOperationException
        list.set(2,"甘雨");

        for (String s:list){
            System.out.println(s);
        }
    }
}
