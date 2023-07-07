package JavaEE.泛型;

import java.util.ArrayList;
import java.util.List;

public class LXTPFGeneric {
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<Object>();
        List<?> list2 = new ArrayList<Number>();
        List<?> list3 = new ArrayList<Integer>();

        System.out.println("----------------");

        //类型通配符上限
//        List<? extends Number> list7 = new ArrayList<Object>();
        List<? extends Number> list4 = new ArrayList<Number>();
        List<? extends Number> list5 = new ArrayList<Integer>();
        System.out.println("----------------");



        List<? super Number> list6 = new ArrayList<Object>();
        List<? super Number> list8 = new ArrayList<Number>();
        //类型通配符下限
//        List<? super Number> list9 = new ArrayList<Integer>();
    }
}
