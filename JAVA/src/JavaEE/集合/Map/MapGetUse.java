package JavaEE.集合.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//夫妻集合的遍历方式
public class MapGetUse {
    public static void main(String[] args) {
        //由HashMap集合实现，元素无序唯一
        Map<String, String> map = new HashMap<String, String>();

        map.put("班尼特", "菲谢尔");
        map.put("夫", "妻");
        map.put("冈崎朋也", "渚");
        map.put("我", "胡桃");


        //Set获取集合,遍历出来
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            System.out.println(key + "," + value);
        }


        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> me:entrySet){
            String key=me.getKey();
            String value=me.getKey();
            System.out.println(key+","+value);
        }

    }
}
