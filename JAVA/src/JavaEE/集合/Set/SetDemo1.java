package JavaEE.集合.Set;

import java.util.HashSet;
import java.util.Set;

//set集合：不包含重复元素的集合
//没有带索引的方法，不能使用普通for循环遍历出来
//HashSet集合不保证元素的插入顺序
public class SetDemo1 {
    public static void main(String[] args) {
        Set<String> s=new HashSet<>();
        s.add("hello");
        s.add("world");

        System.out.println("张自力".hashCode());// 24454417
        s.add("java");
        //不添加重复元素
        s.add("java");
        for(String sss:s){
            System.out.println(sss);
        }
    }
}
