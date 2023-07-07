package JavaEE.集合.Map;

import java.util.*;

public class map集合的排序2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("c", "2019-03");
        map.put("a", "2018-12");
        map.put("b", "2019-01");
        map.put("d", "2019-02");

        //这里将map.entrySet()转换成list
        List<Map.Entry<String, String>> list_map_sort = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        //然后通过比较器来实现排序
        list_map_sort.sort(new Comparator<Map.Entry<String, String>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for (Map.Entry<String, String> mapping : list_map_sort) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }

}
