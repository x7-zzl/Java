package JavaEE.集合.Map;

import java.util.*;

public class map集合的排序 {
    public static void main(String[] args) {
        Map<String, Object> map = new TreeMap<String, Object>(
                new Comparator<String>() {
                    @Override
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });
        map.put("2019-03", "ccccc");
        map.put("2018-12", "aaaaa");
        map.put("2019-01", "bbbbb");
        map.put("2019-02", "ddddd");

        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}
