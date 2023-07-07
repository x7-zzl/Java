package JavaEE.集合.Map;

import java.util.HashMap;
import java.util.Map;
//对两个map集合进行比较
public class MapCompareTest {
    private static int mapCompar(HashMap<Object,Object> hashMap,HashMap<Object,Object> hashMap2) {

        int count=0;
        for (Map.Entry<Object, Object> entry1 : hashMap.entrySet()) {
            String m1value = entry1.getValue() == null ? "" : (String) entry1.getValue();
            String m2value = hashMap2.get(entry1.getKey()) == null ? "" : (String) hashMap2.get(entry1.getKey());
            if (!m1value.equals(m2value)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("key1", "2dr");
        hashMap.put("key2", "key2");
        hashMap.put("key3", "key3");
        HashMap<Object, Object> hashMap2 = new HashMap<>();
        hashMap2.put("key1", "key1");
        hashMap2.put("key2", "key2");
        System.out.println(mapCompar(hashMap,hashMap2));
    }


    //对用户输入的答案和算式正确的结果进行比较
    private static int mapCompare(Map<Integer, Integer> hashMap, Map<Integer, Integer> hashMap1) {

        //记录错题个数
        int count = 0;
        for (Map.Entry<Integer, Integer> entry1 : hashMap.entrySet()) {
            Integer m1value = entry1.getValue();
            Integer m2value = hashMap1.get(entry1.getKey());
            if (!m1value.equals(m2value)) {
                System.out.println("第" + entry1.getKey() + "题错误，小朋友再仔细看看吧!");
                count++;
            }
        }
        return count;
    }
}

