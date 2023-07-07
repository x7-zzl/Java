package JavaEE.集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ArrayListHashMapUse {
    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        HashMap<String, String> hm1 = new HashMap<>();
        hm1.put("清明", "河图");
        hm1.put("冈琦朋也", "古河渚");



        HashMap<String, String> hm2 = new HashMap<>();
        hm2.put("班尼特", "菲谢尔");
        hm2.put("雷泽", "芭芭拉");


        HashMap<String, String> hm3 = new HashMap<>();

        hm3.put("兰陵王", "花木兰");
        hm3.put("锄禾", "当午");


        arrayList.add(hm1);
        arrayList.add(hm2);
        arrayList.add(hm3);


        for (HashMap<String, String> hm : arrayList) {
            Set<String> set = hm.keySet();
            for (String key : set) {

                String value = hm.get(key);
                System.out.println(key + "," + value);
            }
        }

    }
}
