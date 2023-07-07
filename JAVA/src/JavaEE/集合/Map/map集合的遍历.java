package JavaEE.集合.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class map集合的遍历 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        //1
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> m : entries) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }

        //2
        System.out.println(map);


    }
}
