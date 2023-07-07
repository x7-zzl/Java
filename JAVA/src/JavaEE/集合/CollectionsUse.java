package JavaEE.集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections相当于一个对集合操作的工具类
public class CollectionsUse {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(100);
        list.add(70);
        list.add(50);
        list.add(80);
        list.add(200);
        list.add(170);
        list.add(190);
        list.add(10);
        list.add(20);
        list.add(100);


        //排序
        Collections.sort(list);
        System.out.println("排序"+list);

        //翻转
        Collections.reverse(list);
        System.out.println("反转"+list);


        //随机
        Collections.shuffle(list);
        System.out.println("随机"+list);


    }
}
