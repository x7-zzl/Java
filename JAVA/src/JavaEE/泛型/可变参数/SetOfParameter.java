package JavaEE.泛型.可变参数;

import java.util.Set;

public class SetOfParameter {
    public static void main(String[] args) {
        Set<String> set=Set.of("胡桃","魈","刻晴");
       set.add("琴");//UnsupportedOperationException
        set.remove("刻晴");//UnsupportedOperationException


    }
}
