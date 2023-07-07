package JavaEE.集合.Map;

import java.util.*;

public class map_str {
    public static void main(String[] args) {
//        获取输入句柄
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
//        用户输入字符串
        String str = input.next();
//        创建保存字母和次数的集合
        HashMap<Character, Integer> map = new HashMap<>();
//        遍历字符串存入集合
        for (int i = 0; i < str.length(); i++) {
            //  对字符串里面的字母进行判断
            char aChar = str.charAt(i);
            if (map.containsKey(aChar)) {
                Integer value = map.get(aChar);
                map.put(aChar, ++value);
            } else {
                map.put(aChar, 1);
            }
        }

//        遍历输出集合，也可以使用keySet()
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println("字母：" + entry.getKey() + "出现的次数为：" + entry.getValue() + "次");
        }

    }

    public static Object getMaxKey(Map<Character, Integer> map) {
        if (map == null) return null;
        Collection<Integer> values = map.values();
//        Set<Integer> values = map.keySet();
        Object[] obj = values.toArray();
        Arrays.sort(obj);
        return obj[obj.length - 1];
    }
}
