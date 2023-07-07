package JavaEE.集合.Set.TreeSet;

import java.util.TreeSet;

public class TreeSetUse {
    public static void main(String[] args) {
        //使用基础数据类型的包装类类型
        TreeSet<Integer> ts=new TreeSet<>();

        ts.add(10);
        ts.add(20);
        ts.add(89);
        ts.add(30);
        ts.add(44);
        ts.add(40);

        ts.add(40);
        for (Integer i:ts){
            System.out.println(i);
        }
    }
}
