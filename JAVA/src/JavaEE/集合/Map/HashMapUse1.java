package JavaEE.集合.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//保证键的唯一性，第一次出现为添加功能，第二次出现为修改功能
public class HashMapUse1 {
    public static void main(String[] args) {
        //键，值
        //由HashMap集合实现，元素无序唯一
        Map<String, String> map = new HashMap<String, String>();

        map.put("班尼特", "菲谢尔");
        map.put("夫", "妻");
        map.put("冈崎朋也", "渚");
        map.put("我", "胡桃");
        System.out.println(map);
        System.out.println("集合的长度:" + map.size());

        //获取所有键的集合,获取键
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println("set集合:" + s);
        }

        //获取所有键的集合，获取值
        Collection<String> values = map.values();
        for (String s : values) {
            System.out.println("collection集合:" + s);
        }


        //删除
        System.out.println(map.remove("夫"));

        //输出键对应的值
        System.out.println(map.get("魈"));
        System.out.println(map);


        //判断键中元素是否包含
        System.out.println(map.containsKey("魈"));
        System.out.println(map.containsKey("楠"));

        //清空当前集合
        map.clear();
        System.out.println("集合是否为空:" + map.isEmpty());
        System.out.println(map);
    }
}
